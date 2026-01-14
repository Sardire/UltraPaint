package com.ultrapaint.core.implicit;
import com.ultrapaint.App;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoSaver {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final App app;
    private WritableImage snapshot;

    public AutoSaver(App app) {
        this.app = app;
    }

    public void start() {
        executor.scheduleAtFixedRate(() -> {
            try {
                autoSave();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 30, 30, TimeUnit.SECONDS); // delay=30s, period=30s
    }

    public void stop() {
        executor.shutdown();
    }

    public void autoSave() {
        snapshot = new WritableImage((int)app.mainCanva.getWidth(), (int)app.mainCanva.getHeight());

        Platform.runLater(() -> {
            app.mainCanva.snapshot(null, snapshot);

            File file = new File("saves/autosave.png");
            System.out.println(file.getAbsolutePath());
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
                System.out.println("Autosaved!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
