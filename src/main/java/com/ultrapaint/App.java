package com.ultrapaint;

import com.ultrapaint.constants.ToolID;
import com.ultrapaint.core.tool.*;
import com.ultrapaint.core.implicit.StateManager;
import com.ultrapaint.ui.box.UMenuBox;
import com.ultrapaint.ui.UToolBar;

import com.ultrapaint.core.implicit.AutoSaver;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application
{
    public Color currentColor = Color.BLACK;

    public final Canvas mainCanva = new Canvas(1200, 600);
    public final Canvas previewCanva = new Canvas(1200, 600);
    public final BorderPane root = new BorderPane();
    public final Pane canvasPane = new Pane(mainCanva, previewCanva);
    public final Scene scene = new Scene(root);
    public final UToolBar toolbar = new UToolBar(this);
    public final UMenuBox menuBar = new UMenuBox(this);
    public final VBox topContainer = new VBox(menuBar, toolbar);

    public final EraserTool eraserTool = new EraserTool(this);
    public final BrushTool brushTool = new BrushTool(this);
    public final ShaperTool shaperTool = new ShaperTool(this);
    public final BucketTool bucketTool = new BucketTool(this);
    public final ColorPickerTool colorPickerTool = new ColorPickerTool(this);

    public double currentBrushSize = 5;
    public double currentEraserSize = 10;
    public double currentLineSize = 1;
    public ToolID currentTool = ToolID.BRUSH;

    public final GraphicsContext gc = mainCanva.getGraphicsContext2D();
    public final GraphicsContext gcp = previewCanva.getGraphicsContext2D();
    public final PixelWriter pw = gc.getPixelWriter();

    public StateManager stateManager = null;
    public AutoSaver autoSaver = new AutoSaver(this);

    @Override
    public void start(Stage stage){
        initApp();
        stateManager = new StateManager(this, stage);
        stage.setTitle("UltraPaint");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }

    public void initApp(){
        root.setTop(topContainer);
        root.setCenter(canvasPane);

        gc.setImageSmoothing(false);
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvasPane.getWidth(), canvasPane.getHeight());

        brushTool.setBehavior(this);

        autoSaver.start();
    }
}

// More to do:
// - Text box
