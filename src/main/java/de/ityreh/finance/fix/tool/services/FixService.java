package de.ityreh.finance.fix.tool.services;

import de.ityreh.finance.fix.tool.App;
import de.ityreh.finance.fix.tool.events.FixLogEvent;
import quickfix.Application;
import quickfix.Message;
import quickfix.MessageCracker;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionSettings;

public class FixService extends MessageCracker implements Application {

    LogService log;

    private static SessionSettings settings;

    public FixService() {
        this.log = App.getLogService();
    }

    @Override
    public void onCreate(SessionID sessionID) {
        log.notify("onCreate", new FixLogEvent(this, sessionID));
    }

    @Override
    public void onLogon(SessionID sessionID) {
        log.notify("onLogon", new FixLogEvent(this, sessionID));
    }

    @Override
    public void onLogout(SessionID sessionID) {
        log.notify("onLogout", new FixLogEvent(this, sessionID));
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        log.notify("toAdmin", new FixLogEvent(this, sessionID, message));
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) {
        log.notify("fromAdmin", new FixLogEvent(this, sessionID, message));
    }

    @Override
    public void toApp(Message message, SessionID sessionID) {
        log.notify("toApp", new FixLogEvent(this, sessionID, message));
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) {
        log.notify("fromApp", new FixLogEvent(this, sessionID, message));
    }

    public static void setSessionSettings(SessionSettings sessionSettings) {
        settings = sessionSettings;
    }

    public static SessionSettings getSessionSettings(){
        return settings;
    }

    public static void getSession(){
        System.out.println("Session count - " + Session.numSessions());
    }

}
