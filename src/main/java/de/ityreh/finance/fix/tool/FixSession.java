package de.ityreh.finance.fix.tool;

import de.ityreh.finance.fix.tool.events.LogEvent;
import de.ityreh.finance.fix.tool.services.LogManager;
import quickfix.Application;
import quickfix.Message;
import quickfix.MessageCracker;
import quickfix.SessionID;
import quickfix.SessionSettings;

public class FixSession extends MessageCracker implements Application {

    LogManager log;

    private static SessionSettings settings;

    public FixSession(LogManager log) {
        this.log = log;
    }

    @Override
    public void onCreate(SessionID sessionID) {
        log.notify("onCreate", new LogEvent(this, sessionID));
    }

    @Override
    public void onLogon(SessionID sessionID) {
        log.notify("onLogon", new LogEvent(this, sessionID));
    }

    @Override
    public void onLogout(SessionID sessionID) {
        log.notify("onLogout", new LogEvent(this, sessionID));
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        log.notify("toAdmin", new LogEvent(this, sessionID, message));
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) {
        log.notify("fromAdmin", new LogEvent(this, sessionID, message));
    }

    @Override
    public void toApp(Message message, SessionID sessionID) {
        log.notify("toApp", new LogEvent(this, sessionID, message));
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) {
        log.notify("fromApp", new LogEvent(this, sessionID, message));
    }

    public static void setSessionSettings(SessionSettings sessionSettings) {
        settings = sessionSettings;
    }
}
