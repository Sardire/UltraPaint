package com.ultrapaint.ui.box;

import javafx.scene.control.*;
import com.ultrapaint.App;
import javafx.scene.layout.HBox;

public class UMenuBox extends HBox {
    public UMenuBox(App app) {
        MenuBar menuBar = new MenuBar();

        MenuItem newButton = new MenuItem("New");
        MenuItem saveButton = new MenuItem("Save");
        saveButton.setOnAction(e -> {
            app.stateManager.saveFile();
        });
        MenuItem openButton = new MenuItem("Open");
        openButton.setOnAction(e -> {
            app.stateManager.openFile();
        });
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().addAll(newButton, saveButton, openButton);
        
        Menu editMenu = new Menu("Edit");
        Button undoButton = new Button("Undo");
        Button redoButton = new Button("Redo");

        undoButton.setOnAction(e -> {
            app.stateManager.undo();
        });

        redoButton.setOnAction(e -> {
            app.stateManager.redo();
        });

        menuBar.getMenus().addAll(fileMenu, editMenu);
        HBox buttons = new HBox(undoButton, redoButton);

        this.getChildren().addAll(menuBar, buttons);
    }
}