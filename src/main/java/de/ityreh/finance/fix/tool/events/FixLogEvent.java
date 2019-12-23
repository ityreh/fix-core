package de.ityreh.finance.fix.tool.events;

import quickfix.Message;
import quickfix.SessionID;

import java.util.EventObject;

public class FixLogEvent extends EventObject {

    private SessionID sessionId;
    private Message message;

    public FixLogEvent(Object source, SessionID sessionId, Message message) {
        super(source);
        this.sessionId = sessionId;
        this.message = message;
    }

    public FixLogEvent(Object source, SessionID sessionId) {
        super(source);
        this.sessionId = sessionId;
    }

    public SessionID getSessionId() {
        return sessionId;
    }

    public Message getMessage() {
        return message;
    }
}
