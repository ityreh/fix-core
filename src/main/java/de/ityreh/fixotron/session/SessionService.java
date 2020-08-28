package de.ityreh.fixotron.session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.ityreh.fixotron.core.FixApplication;
import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import quickfix.Acceptor;
import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.JdbcLogFactory;
import quickfix.JdbcStoreFactory;
import quickfix.MessageFactory;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;

@ApplicationScoped
public class SessionService {

    private static final Logger LOG = LoggerFactory.getLogger(SessionService.class);

    private final SessionConfigurationService sessionConfigurationService;

    @Inject
    @DataSource("quickfix")
    AgroalDataSource quickfixDataSource;

    public SessionService() {
        sessionConfigurationService = new SessionConfigurationService();

        assert quickfixDataSource != null;
        LOG.info(String.valueOf(quickfixDataSource.getConfiguration()));
    }

    public void createAccetor() throws ConfigError {
        Application application = new FixApplication();
        SessionSettings settings = sessionConfigurationService.settings();
        JdbcStoreFactory storeFactory = new JdbcStoreFactory(settings);
        storeFactory.setDataSource(quickfixDataSource);
        JdbcLogFactory logFactory = new JdbcLogFactory(settings);
        logFactory.setDataSource(quickfixDataSource);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Acceptor acceptor = new SocketAcceptor(application, storeFactory, settings, logFactory, messageFactory);
        acceptor.start();
    }

    public void createInitiator() {

    }
}
