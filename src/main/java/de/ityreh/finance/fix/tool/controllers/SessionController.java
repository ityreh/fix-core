package de.ityreh.finance.fix.tool.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SessionController extends MenuController {
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
            String text = new StringBuilder()
                    .append("BeginString: " + beginString.getText() + "\n")
                    .append("SenderCompID: " + senderCompId.getText() + "\n")
                    .append("TargetCompID: " + targetCompId.getText() + "\n")
                    .toString();
            output.setText(text);
        });
    }


}
