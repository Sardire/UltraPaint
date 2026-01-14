package com.ultrapaint.core.implicit;

import com.ultrapaint.App;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
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
        app.gc.fillRect(0, 0, app.mainCanva.getWidth(), app.mainCanva.getHeight());
        WritableImage snapshot = new WritableImage((int)app.mainCanva.getWidth(), (int)app.mainCanva.getHeight());
        app.mainCanva.snapshot(null, snapshot);
        curr = new State(snapshot);
        front = curr;
        top = curr;

        app.scene.getAccelerators().put(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN), this::undo);
        app.scene.getAccelerators().put(new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN), this::redo);
        app.scene.getAccelerators().put(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN), this::saveFile);
        app.scene.getAccelerators().put(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN), this::openFile);

//        app.canvasPane.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
//            takeSnapshot();
//            System.out.println("luu");
//        });
    }

    public void undo(){
        if (curr.prev != null){
            curr = curr.prev;
//            app.gc.clearRect(0, 0, app.canvas.getWidth(), app.canvas.getHeight());
            app.gc.drawImage(curr.img, 0, 0);
        }
    };

    public void redo(){
        if (curr.next != null){
            curr = curr.next;
//            app.gc.clearRect(0, 0, app.canvas.getWidth(), app.canvas.getHeight());
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
            WritableImage image = new WritableImage((int) app.mainCanva.getWidth(), (int) app.mainCanva.getHeight());

            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);

            app.mainCanva.snapshot(params, image);

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

    public void takeSnapshot(){
        WritableImage snapshottemp = new WritableImage((int)app.mainCanva.getWidth(), (int)app.mainCanva.getHeight());
        app.mainCanva.snapshot(null, snapshottemp);

        // Xóa các State phía sau để giải phóng memory
        State temp = curr.next;
        while (temp != null) {
            State next = temp.next;

            // QUAN TRỌNG: Giải phóng reference đến ảnh
            if (temp.img != null) {
                // JavaFX image không có dispose(), nhưng có thể set null
                temp.img = null;
            }

            temp.prev = null;
            temp.next = null;
            temp = next;
            stateSize--;
        }

        stateSize++;
        curr.next = new State(snapshottemp);
        curr.next.prev = curr;
        curr = curr.next;
        top = curr;

        while (stateSize > MAX_SIZE){
            // Giải phóng ảnh của front trước khi xóa
            if (front.img != null) {
                front.img = null;
            }
            front = front.next;
            if (front != null) {
                front.prev = null;
            }
            stateSize--;
        }

        // Gợi ý GC thu hồi memory
        System.gc();
    }
}
