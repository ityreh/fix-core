package de.ityreh.finance.fix.tool.listeners;

import de.ityreh.finance.fix.tool.events.FixLogEvent;
import de.ityreh.finance.fix.tool.events.InfoLogEvent;

import java.util.EventListener;

public interface LogListener extends EventListener {
    public void log(String eventType, FixLogEvent fixLogEvent);
    public void log(String eventType, InfoLogEvent infoLogEvent);
}
