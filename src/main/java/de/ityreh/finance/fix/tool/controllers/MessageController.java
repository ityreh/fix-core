package de.ityreh.finance.fix.tool.controllers;

import de.ityreh.finance.fix.tool.services.FixService;
import de.ityreh.finance.fix.tool.utils.MessageConverter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import quickfix.ConfigError;
import quickfix.InvalidMessage;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.SessionSettings;

public class MessageController {

    @FXML
    TextArea marketOrder, limitOrder, stopOrder, icebergOrder, defectOrder, cancelOrder, cancelReplaceOrder,
            rejectMessage;
    @FXML
    Button marketOrderButton, limitOrderButton, stopOrderButton, icebergOrderButton, defectOrderButton,
            cancelOrderButton, cancelReplaceOrderButton, rejectMessageButton;

    public MessageController() {

    }

    @FXML
    private void initialize() {
        initMessageSend(marketOrderButton, marketOrder);
        initMessageSend(limitOrderButton, limitOrder);
        initMessageSend(stopOrderButton, stopOrder);
        initMessageSend(icebergOrderButton, icebergOrder);
        initMessageSend(defectOrderButton, defectOrder);
        initMessageSend(cancelOrderButton, cancelOrder);
        initMessageSend(cancelReplaceOrderButton, cancelReplaceOrder);
        initMessageSend(rejectMessageButton, rejectMessage);
    }

    private void initMessageSend(Button button, TextArea textArea){
        button.setOnAction(actionEvent -> {
            try {
                sendMessage(textArea.getText());
            } catch (ConfigError | InvalidMessage | SessionNotFound error) {
                error.printStackTrace();
            }
        });
    }

    private void sendMessage(String message) throws ConfigError, InvalidMessage, SessionNotFound {
        SessionSettings settings = FixService.getSessionSettings();
        SessionID sessionID = new SessionID(settings.getString("BeginString"),
                settings.getString("SenderCompID"), settings.getString("TargetCompID"));
        FixService.getSession();
        Session.sendToTarget(MessageConverter.stringToFix(Session.lookupSession(sessionID), message));
    }
}
