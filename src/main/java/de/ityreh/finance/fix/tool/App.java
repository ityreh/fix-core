package de.ityreh.finance.fix.tool;

import de.ityreh.finance.fix.tool.services.LogManager;
import de.ityreh.finance.fix.tool.views.LogView;
import de.ityreh.finance.fix.tool.views.MessageView;
import de.ityreh.finance.fix.tool.views.SessionView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage stage;
    private static Scene sessionView, messageView, logView;
    private static LogManager log;

    public static void main(String... args) throws Exception {
        log = new LogManager("onCreate", "onLogon", "onLogout", "toAdmin", "fromAdmin", "toApp", "fromApp");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            initViews();
            stage = primaryStage;
            stage.setTitle("FIX Tool");
            setSessionView();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSessionView(){
        stage.setScene(sessionView);
    }

    public static void setMessageView(){
        stage.setScene(messageView);
    }

    public static void setLogView(){
        stage.setScene(logView);
    }

    public static LogManager getLogManager(){
        return log;
    }

    private void initViews() throws IOException {
        sessionView = new SessionView();
        messageView = new MessageView();
        logView = new LogView();
    }
}

