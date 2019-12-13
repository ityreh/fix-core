package de.ityreh.finance.fix.tool.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuController {

    private static final String VERSION = "0.0.1";

    @FXML
    private VBox sessionMenu;
    @FXML
    private VBox sessionMenuLabel;
    @FXML
    private VBox messageMenu;
    @FXML
    private VBox messageMenuLabel;
    @FXML
    private VBox logMenu;
    @FXML
    private VBox logMenuLabel;
    @FXML
    private Label version;

    public MenuController() {
    }

    @FXML
    private void initialize() {
    }
}
