package de.ityreh.finance.fix.tool.services;

import de.ityreh.finance.fix.tool.events.LogEvent;
import de.ityreh.finance.fix.tool.listeners.LogListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogManager {
    Map<String, List<LogListener>> listeners = new HashMap<>();

    public LogManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, LogListener listener) {
        List<LogListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, LogListener listener) {
        List<LogListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, LogEvent logEvent) {
        List<LogListener> users = listeners.get(eventType);
        for (LogListener listener : users) {
            listener.log(eventType, logEvent);
        }
    }
}
