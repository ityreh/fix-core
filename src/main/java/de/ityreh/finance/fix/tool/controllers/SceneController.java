package de.ityreh.finance.fix.tool.controllers;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class SceneController {
    private HashMap<String, AnchorPane> sceneMap = new HashMap<>();
    private Scene active;

    public SceneController(Scene active){
        this.active = active;
    }

    public void addScene(String name, AnchorPane pane){
        sceneMap.put(name, pane);
    }

    public void removeScene(String name){
        sceneMap.remove(name);
    }

    public void activate(String name){
        active.setRoot( sceneMap.get(name) );
    }

    public Scene getActive(){
        return active;
    }
}
