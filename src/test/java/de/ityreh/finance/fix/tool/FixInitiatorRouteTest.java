package de.ityreh.finance.fix.tool;

import org.apache.camel.Exchange;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FixInitiatorRouteTest extends CamelTestSupport {

    @Before
    public void mockEndpoints() throws Exception {
        context.getRouteDefinition("fixSender").adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                replaceFromWith("file://testInput");
                mockEndpointsAndSkip("quickfix:config/initiator.cfg");
            }
        });

    }

    @Test
    @Ignore
    public void testFixSender() throws InterruptedException {
        String fixTestMessage = "8=FIX.4.2;9=;35=D;49=FIXT_INITIATOR;56=VENDOR_ACCEPTOR;34=;52=;11=1;60=20191015-11:11:12.345;48=SID123;55=RRC;38=100;54=1;40=1;77=O;59=0;1=ACC123;528=A;582=1;10=;\n";

        MockEndpoint quickfixMock = getMockEndpoint("quickfix:config/initiator.cfg");
        quickfixMock.expectedMessageCount(1);

        template.sendBody("file://testInput", fixTestMessage);
        assertMockEndpointsSatisfied();
    }

}
