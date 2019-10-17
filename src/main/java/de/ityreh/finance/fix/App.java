package de.ityreh.finance.fix;

import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class App {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new FixInitiatorRouteBuilder());
        main.run(args);
    }

}

