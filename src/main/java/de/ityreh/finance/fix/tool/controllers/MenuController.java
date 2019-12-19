package de.ityreh.finance.fix.tool.controllers;

import de.ityreh.finance.fix.tool.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class MenuController {

    private static final String VERSION = "0.0.1";
    private static final String COLOR_MENU = "#fff";
    private static final String COLOR_ACTIVE_MENU = "#5e92f3";

    @FXML
    private HBox sessionMenu;
    @FXML
    private Label sessionMenuLabel;
    @FXML
    private HBox messageMenu;
    @FXML
    private Label messageMenuLabel;
    @FXML
    private HBox logMenu;
    @FXML
    private Label logMenuLabel;
    @FXML
    private Label version;

    public MenuController() {
    }

    @FXML
    private void initialize() {
        sessionMenuLabel.setTextFill(Color.web(COLOR_ACTIVE_MENU));
        initSessionMenu();
        initMessageMenu();
        initLogMenu();
        initVersion();
    }

    private void initSessionMenu() {
        sessionMenu.setOnMouseClicked(mouseEvent -> {
            App.setSessionView();
            activateSessionMenu();
        });
    }

    private void initMessageMenu() {
        messageMenu.setOnMouseClicked(mouseEvent -> {
            App.setMessageView();
            activateMessageMenu();
        });
    }

    private void initLogMenu() {
        logMenu.setOnMouseClicked(mouseEvent -> {
            App.setLogView();
            activateLogMenu();
        });
    }

    private void initVersion() {
        version.setText("Version: " + VERSION);
    }

    private void activateSessionMenu(){
        sessionMenuLabel.setTextFill(Color.web(COLOR_ACTIVE_MENU));
        messageMenuLabel.setTextFill(Color.web(COLOR_MENU));
        logMenuLabel.setTextFill(Color.web(COLOR_MENU));
    }

    private void activateMessageMenu(){
        sessionMenuLabel.setTextFill(Color.web(COLOR_MENU));
        messageMenuLabel.setTextFill(Color.web(COLOR_ACTIVE_MENU));
        logMenuLabel.setTextFill(Color.web(COLOR_MENU));
    }

    private void activateLogMenu(){
        sessionMenuLabel.setTextFill(Color.web(COLOR_MENU));
        messageMenuLabel.setTextFill(Color.web(COLOR_MENU));
        logMenuLabel.setTextFill(Color.web(COLOR_ACTIVE_MENU));
    }
}
