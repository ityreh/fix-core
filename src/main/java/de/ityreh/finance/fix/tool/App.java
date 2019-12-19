package de.ityreh.finance.fix.tool;

import de.ityreh.finance.fix.tool.views.LogView;
import de.ityreh.finance.fix.tool.views.MessageView;
import de.ityreh.finance.fix.tool.views.SessionView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.camel.main.Main;

import java.io.IOException;

public class App extends Application {

    private static Stage stage;
    private static Scene sessionView, messageView, logView;

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new FixInitiatorRouteBuilder());
        //main.run(args);

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

    private void initViews() throws IOException {
        sessionView = new SessionView();
        messageView = new MessageView();
        logView = new LogView();
    }
}

