package com.ultrapaint.ui;

import javafx.scene.control.*;
import com.ultrapaint.App;

public class UMenuBar extends MenuBar {
    public UMenuBar(App app) {
        MenuItem newButton = new MenuItem("New");
        MenuItem saveButton = new MenuItem("Save");
        MenuItem openButton = new MenuItem("Open");
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().addAll(newButton, saveButton, openButton);
        
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        this.getMenus().addAll(fileMenu, editMenu, helpMenu);
    }
}