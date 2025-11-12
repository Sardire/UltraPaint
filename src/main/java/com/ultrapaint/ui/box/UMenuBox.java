package com.ultrapaint.ui.box;

import javafx.scene.control.*;
import com.ultrapaint.App;

public class UMenuBox extends MenuBar {
    public UMenuBox(App app) {
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