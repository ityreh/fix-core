package de.ityreh.fixotron.core;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.Application;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;

public class FixApplication implements Application {

    private static final Logger LOG = LoggerFactory.getLogger(FixApplication.class);

    @Override
    public void onCreate(SessionID sessionID) {
        LOG.info("Created Session {}", sessionID);
    }

    @Override
    public void onLogon(SessionID sessionID) {
        LOG.info("Logon on Session {}", sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        LOG.info("Logout on Session {}", sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        LOG.info("Send admin message on {} : {}", message, sessionID);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        LOG.info("Receive admin message from {} : {}", message, sessionID);
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        LOG.info("Send app message on {} : {}", message, sessionID);
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        LOG.info("Receive app message from {} : {}", message, sessionID);
    }
}
