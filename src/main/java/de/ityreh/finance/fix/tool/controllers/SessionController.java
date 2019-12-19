package de.ityreh.finance.fix.tool.controllers;

import de.ityreh.finance.fix.tool.FixSession;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileStoreFactory;
import quickfix.Initiator;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.SLF4JLogFactory;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;

public class SessionController {
    @FXML
    TextField beginString;
    @FXML
    TextField senderCompId;
    @FXML
    TextField targetCompId;
    @FXML
    TextField connectionType;
    @FXML
    TextField timeZone;
    @FXML
    TextField startTime;
    @FXML
    TextField endTime;
    @FXML
    TextField socketConnectPort;
    @FXML
    TextField socketConnectHost;
    @FXML
    Text output;
    @FXML
    Button startButton;

    public SessionController() {

    }

    @FXML
    private void initialize() {
        initSessionStartButton();
    }

    private void initSessionStartButton() {
        startButton.setOnAction(actionEvent -> {
            try {
                onActionStartButton();
                output.setText("Session started: " + beginString.getText() + ":" + senderCompId.getText() + "->"
                    + targetCompId.getText());
            } catch (ConfigError configError) {
                output.setText(configError.toString());
                configError.printStackTrace();
            }
        });
    }

    private void onActionStartButton() throws ConfigError {
        if (connectionType.getText().equals("acceptor")) {
            output.setText("Acceptors are not supported, yet. Please configure an Initiator.");
        } else {
            SessionSettings settings = new SessionSettings();
            settings.setString("BeginString", beginString.getText());
            settings.setString("SenderCompID", senderCompId.getText());
            settings.setString("TargetCompID", targetCompId.getText());
            settings.setString("ConnectionType", connectionType.getText());
            settings.setString("TimeZone", timeZone.getText());
            settings.setString("StartTime", startTime.getText());
            settings.setString("EndTime", endTime.getText());
            settings.setString("SocketConnectPort", socketConnectPort.getText());
            settings.setString("SocketConnectHost", socketConnectHost.getText());

            Application application = new FixSession();
            ((FixSession) application).setSessionSettings(settings);
            MessageStoreFactory storeFactory = new FileStoreFactory(settings);
            LogFactory logFactory = new SLF4JLogFactory(settings);
            MessageFactory messageFactory = new DefaultMessageFactory();
            Initiator initiator = new SocketInitiator(application, storeFactory, settings, logFactory, messageFactory);
            initiator.start();
        }
    }
}
