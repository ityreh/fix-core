package de.ityreh.finance.fix.tool.controllers;

import de.ityreh.finance.fix.tool.App;
import de.ityreh.finance.fix.tool.events.FixLogEvent;
import de.ityreh.finance.fix.tool.events.InfoLogEvent;
import de.ityreh.finance.fix.tool.listeners.LogListener;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class LogController implements LogListener {
    @FXML
    private TextArea logField;

    public LogController(){
        //TODO: LogManager - subscribe for groups or all
        App.getLogService().subscribe("onCreate", this);
        App.getLogService().subscribe("onLogon", this);
        App.getLogService().subscribe("onLogout", this);
        App.getLogService().subscribe("toAdmin", this);
        App.getLogService().subscribe("fromAdmin", this);
        App.getLogService().subscribe("toApp", this);
        App.getLogService().subscribe("fromApp", this);
        App.getLogService().subscribe("info", this);
    }

    @FXML
    private void initialize(){
    }

    @Override
    public void log(String eventType, FixLogEvent fixLogEvent) {
        logField.appendText(eventType.toString() + " ### " + fixLogEvent.getSessionId());
        if(!fixLogEvent.getMessage().isEmpty()) logField.appendText(" ### " + fixLogEvent.getMessage().toString());
        logField.appendText("\n");
    }

    @Override
    public void log(String eventType, InfoLogEvent infoLogEvent) {
        logField.appendText(eventType.toString() + " ### " + infoLogEvent.getMessage() + "\n");
    }
}
