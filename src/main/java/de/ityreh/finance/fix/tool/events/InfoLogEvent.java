package de.ityreh.finance.fix.tool.events;

import java.util.EventObject;

public class InfoLogEvent extends EventObject {

    private String message;

    public InfoLogEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
