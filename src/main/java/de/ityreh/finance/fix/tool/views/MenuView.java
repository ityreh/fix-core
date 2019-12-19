package de.ityreh.finance.fix.tool.views;

import de.ityreh.finance.fix.tool.App;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenuView extends Scene {

    private static final double HEIGHT = 600;
    private static final double WIDTH = 900;

    ObservableList<Node> fxList;

    public MenuView() throws IOException {
        super(new Group());
        AnchorPane root = new AnchorPane();
        root.setPrefHeight(HEIGHT);
        root.setPrefWidth(WIDTH);
        fxList = root.getChildren();
        initNodes();
        this.getStylesheets().add("css/style.css");
        this.setRoot(root);
    }

    protected void initNodes() throws IOException {
        fxList.add(loadMenu());
    }

    protected VBox loadMenu() throws IOException {
        VBox menu = new FXMLLoader(App.class.getResource("/fxml/menu.fxml")).load();
        AnchorPane.setLeftAnchor(menu, 0.0);
        AnchorPane.setTopAnchor(menu, 0.0);
        AnchorPane.setBottomAnchor(menu, 0.0);
        return menu;
    }

    protected VBox loadView(String path) throws IOException {
        VBox view = new FXMLLoader(App.class.getResource(path)).load();
        AnchorPane.setLeftAnchor(view, 200.0);
        AnchorPane.setTopAnchor(view, 0.0);
        AnchorPane.setBottomAnchor(view, 0.0);
        AnchorPane.setRightAnchor(view, 0.0);
        return view;
    }
}
