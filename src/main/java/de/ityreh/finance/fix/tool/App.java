package de.ityreh.finance.fix.tool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.camel.main.Main;

import java.awt.*;

/**
 * A Camel Application
 */
public class App extends Application {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new FixInitiatorRouteBuilder());
        //main.run(args);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/session.fxml"));
            primaryStage.setTitle("FIX Tool");
            primaryStage.setScene(new Scene(root, screenSize.width, screenSize.height));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

