package com.ultrapaint;

import com.ultrapaint.constants.ToolID;
import com.ultrapaint.core.BrushTool;
import com.ultrapaint.core.EraserTool;
import com.ultrapaint.ui.UColorBar;
import com.ultrapaint.ui.UMenuBar;
import com.ultrapaint.ui.UToolBar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application
{
    public final Canvas canvas = new Canvas(1200, 600);
    public final BorderPane root = new BorderPane();
    public final Pane canvasPane = new Pane(canvas);
    public final Scene scene = new Scene(root);
    public final UToolBar toolbar = new UToolBar(this);
    public final UMenuBar menuBar = new UMenuBar(this);
    public final VBox topContainer = new VBox(menuBar, toolbar);
    public final UColorBar colorBar = new UColorBar(this);

    public final EraserTool eraserTool = new EraserTool(this);
    public final BrushTool brushTool = new BrushTool(this);

    public Color currentColor = Color.BLACK;
    public double currentBrushSize = 5;
    public double currentEraserSize = 10;
    public ToolID currentTool = ToolID.BRUSH;
    public final GraphicsContext gc = canvas.getGraphicsContext2D();
    public Rectangle eraserPreview = new Rectangle(0, 0, 0, 0);

    @Override
    public void start(Stage stage){
        initApp();

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
        toolbar.getItems().add(colorBar);

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvasPane.getWidth(), canvasPane.getHeight());

        brushTool.setBehavior(this);

        root.addEventHandler(MouseEvent.MOUSE_MOVED, e -> {
            if (currentTool != ToolID.ERASER) eraserPreview.setVisible(false);
        });
    }
}
