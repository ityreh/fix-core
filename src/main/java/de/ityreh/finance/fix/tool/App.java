package de.ityreh.finance.fix.tool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.camel.main.Main;

import java.awt.*;
import java.io.IOException;

public class App extends Application {

    private static Stage stage;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new FixInitiatorRouteBuilder());
        //main.run(args);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("FIX Tool");
            setSessionScene();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSessionScene() throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/fxml/session.fxml")),
                screenSize.width, screenSize.height));
    }

    public static void setMessageScene() throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/fxml/message.fxml")),
                screenSize.width, screenSize.height));
    }

    public static void setLogScene() throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/fxml/log.fxml")),
                screenSize.width, screenSize.height));
    }
}

