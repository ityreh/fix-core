package de.ityreh.finance.fix.tool.controllers;

import de.ityreh.finance.fix.tool.App;
import de.ityreh.finance.fix.tool.events.LogEvent;
import de.ityreh.finance.fix.tool.listeners.LogListener;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class LogController implements LogListener {
    @FXML
    private TextArea logField;

    public LogController(){
        //TODO: LogManager - subscribe for groups or all
        App.getLogManager().subscribe("onCreate", this);
        App.getLogManager().subscribe("onLogon", this);
        App.getLogManager().subscribe("onLogout", this);
        App.getLogManager().subscribe("toAdmin", this);
        App.getLogManager().subscribe("fromAdmin", this);
        App.getLogManager().subscribe("toApp", this);
        App.getLogManager().subscribe("fromApp", this);
    }

    @FXML
    private void initialize(){
    }

    @Override
    public void log(String eventType, LogEvent logEvent) {
        logField.appendText(eventType.toString() + " ### " + logEvent.getSessionId());
        if(!logEvent.getMessage().isEmpty()) logField.appendText(" ### " + logEvent.getMessage().toString());
        logField.appendText("\n");
    }
}
