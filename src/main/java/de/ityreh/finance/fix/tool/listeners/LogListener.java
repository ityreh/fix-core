package de.ityreh.finance.fix.tool.listeners;

import de.ityreh.finance.fix.tool.events.LogEvent;

import java.util.EventListener;

public interface LogListener extends EventListener {
    public void log(String eventType, LogEvent logEvent);
}
