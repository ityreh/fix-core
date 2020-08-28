package de.ityreh.fixotron.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.Acceptor;
import quickfix.Session;
import quickfix.SessionFactory;
import quickfix.SessionID;
import quickfix.SessionSettings;

public class SessionConfigurationService {

    private static final Logger LOG = LoggerFactory.getLogger(SessionService.class);

    public SessionConfigurationService() {

    }

    public SessionSettings settings() {
        SessionSettings settings = new SessionSettings();

        settings.setString(SessionSettings.BEGINSTRING, "FIXT.1.1");
        settings.setString(SessionSettings.SENDERCOMPID, "FIXOTRON");

        SessionID sessionID = new SessionID("FIXT.1.1", "FIXOTRON", "COUNTERPARTY");

        settings.setString(sessionID, SessionSettings.TARGETCOMPID, "COUNTERPARTY");

        settings.setString(sessionID, Session.SETTING_DEFAULT_APPL_VER_ID, "9");

        settings.setString(sessionID, SessionFactory.SETTING_CONNECTION_TYPE, SessionFactory.ACCEPTOR_CONNECTION_TYPE);

        settings.setString(sessionID, Acceptor.SETTING_SOCKET_ACCEPT_ADDRESS, "127.0.0.1");
        settings.setString(sessionID, Acceptor.SETTING_SOCKET_ACCEPT_PORT, "9424");

        settings.setString(sessionID, Session.SETTING_START_TIME, "00:00:00");
        settings.setString(sessionID, Session.SETTING_END_TIME, "00:00:00");

        LOG.info("Configuration : {}", settings.toString());

        return settings;
    }
}
