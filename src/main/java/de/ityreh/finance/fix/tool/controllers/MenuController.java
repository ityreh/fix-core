package de.ityreh.finance.fix.tool.controllers;

import de.ityreh.finance.fix.tool.App;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;

public class MenuController {

    private static final String VERSION = "0.0.1";
    private static final String COLOR_ACTIVE_MENU = "#0099ff";

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
    private VBox engineInfo;
    @FXML
    private Label version;

    public MenuController() {
    }

    @FXML
    private void initialize(){
        initMenu();
        initSessionMenu();
        initMessageMenu();
        initLogMenu();
        initVersion();
    }

    private void initMenu(){
        //TODO: notice active menu
        switch(0){
            case 0: sessionMenuLabel.setTextFill(Color.web(COLOR_ACTIVE_MENU)); break;
            case 1: messageMenuLabel.setTextFill(Color.web(COLOR_ACTIVE_MENU)); break;
            case 2: logMenuLabel.setTextFill(Color.web(COLOR_ACTIVE_MENU));
        }
    }

    private void initSessionMenu(){
        sessionMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    App.setSessionScene();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initMessageMenu(){
        messageMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    App.setMessageScene();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initLogMenu(){
        logMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    App.setLogScene();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initVersion(){
        version.setText("Version: " + VERSION);
    }
}
