package com.ultrapaint.core;

import com.ultrapaint.App;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.io.File;

public class StateManager {
    private final App app;
    private final Stage stage;
    private State curr;
    private State front;
    private State top;
    private int stateSize;
    private final int MAX_SIZE = 10;
    public StateManager(App app, Stage stage){
        this.app = app;

        this.stateSize = 1;
        this.stage = stage;

        app.gc.setFill(Color.WHITE);
        app.gc.fillRect(0, 0, app.canvas.getWidth(), app.canvas.getHeight());
        WritableImage snapshot = new WritableImage((int)app.canvas.getWidth(), (int)app.canvas.getHeight());
        app.canvas.snapshot(null, snapshot);
        curr = new State(snapshot);
        front = curr;
        top = curr;

        app.scene.getAccelerators().put(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN), () -> undo());
        app.scene.getAccelerators().put(new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN), () -> redo());
        app.scene.getAccelerators().put(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN), () -> saveFile());
        app.scene.getAccelerators().put(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN), () -> openFile());

        app.canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            WritableImage snapshottemp = new WritableImage((int)app.canvas.getWidth(), (int)app.canvas.getHeight());
            app.canvas.snapshot(null, snapshottemp);

            State temp = curr.next;
            while (temp != null){
                stateSize--;
                temp = temp.next;
            }

            stateSize++;
            curr.next = new State(snapshottemp);
            curr.next.prev = curr;
            curr = curr.next;
            top = curr;

            while (stateSize > MAX_SIZE){
                front = front.next;
                front.prev = null;
                stateSize--;
            }
        });
    }

    public void undo(){
        if (curr.prev != null){
            curr = curr.prev;
            app.gc.clearRect(0, 0, app.canvas.getWidth(), app.canvas.getHeight());
            app.gc.drawImage(curr.img, 0, 0);
        }
    };

    public void redo(){
        if (curr.next != null){
            curr = curr.next;
            app.gc.clearRect(0, 0, app.canvas.getWidth(), app.canvas.getHeight());
            app.gc.drawImage(curr.img, 0, 0);
        }
    }

    public void saveFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PNG Files", "*.png")
        );

        File file = fileChooser.showSaveDialog(stage);
        if (file == null) {
            return;
        }
        try {
            WritableImage image = new WritableImage((int) app.canvas.getWidth(), (int) app.canvas.getHeight());

            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);

            app.canvas.snapshot(params, image);

            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);

            System.out.println("Saved to: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Image image = new Image(file.toURI().toString()); // đọc file thành Image
            app.gc.drawImage(image, 0, 0);
        }
    }
}
