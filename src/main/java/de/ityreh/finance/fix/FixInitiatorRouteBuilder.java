package de.ityreh.finance.fix;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * RouteBuilder for a FIX Initiator
 */
public class FixInitiatorRouteBuilder extends RouteBuilder {

    Processor converter = new StringToFixProcessor();

    /**
     * Configuration for a FIX Initiator
     */
    public void configure() {
        from("quickfix:config/initiator.cfg").routeId("fixReceiver")
                .log("${body}");

        from("file:data?noop=true").routeId("fileReader")
                .log("Start sending initiator FIX test messages...")
                .split().tokenize("\n").to("direct:processInitiatorFixMessage")
                .log("End of sending initiator FIX test messages.");

        from("direct:processInitiatorFixMessage").routeId("fixSender")
                .log("Convert String test message: ${body}")
                .process(converter)
                .log("Send FIX test message: ${body}")
                .throttle(5).timePeriodMillis(1000).to("quickfix:config/initiator.cfg");

    }
}
