package de.ityreh.finance.fix.tool.controllers;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class AppController {
    private HashMap<String, AnchorPane> sceneMap = new HashMap<>();
    private Scene main;

    public AppController(Scene main){
        this.main = main;
    }

    public void addScene(String name, AnchorPane pane){
        sceneMap.put(name, pane);
    }

    public void removeScene(String name){
        sceneMap.remove(name);
    }

    public void activate(String name){
        main.setRoot( sceneMap.get(name) );
    }
}
