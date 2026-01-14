package com.ultrapaint.ui.box;

import com.ultrapaint.App;
import com.ultrapaint.ui.button.UButton;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class URGBBox extends VBox {
    public final Slider redSlider = new Slider(0, 255, 0);
    public final Slider greenSlider = new Slider(0, 255, 0);
    public final Slider blueSlider = new Slider(0, 255, 0);
    public Color currentColor = Color.BLACK;
    public final Circle circle = new Circle(15, currentColor);
    public final UButton btn = new UButton();
    public URGBBox(App app){
        super();
        HBox redBox = new HBox(new Label("Red: "), redSlider);
        HBox greenBox = new HBox(new Label("Green: "), greenSlider);
        HBox blueBox = new HBox(new Label("Blue: "),blueSlider);
        redBox.setAlignment(Pos.CENTER_RIGHT);
        greenBox.setAlignment(Pos.CENTER_RIGHT);
        blueBox.setAlignment(Pos.CENTER_RIGHT);

        circle.setStrokeWidth(3);
        circle.setStroke(Color.DARKGRAY);
        circle.setFill(Color.BLACK);

        btn.setGraphic(circle);

        btn.setOnMouseClicked(e -> {
            app.toolbar.setColor(currentColor);
        });

        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double redValue = newValue.doubleValue() / 255.0;
            currentColor = new Color(redValue,
                    currentColor.getGreen(),
                    currentColor.getBlue(),
                    currentColor.getOpacity());
            setColor();
        });

        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double greenValue = newValue.doubleValue() / 255.0;
            currentColor = new Color(
                    currentColor.getRed(),
                    greenValue,
                    currentColor.getBlue(),
                    currentColor.getOpacity());
            setColor();
        });

        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double blueValue = newValue.doubleValue() / 255.0;
            currentColor = new Color(currentColor.getRed(),
                    currentColor.getGreen(),
                    blueValue,
                    currentColor.getOpacity());
            setColor();
        });

        VBox sliders = new VBox(redBox, greenBox, blueBox);
        VBox color = new VBox(btn);
        HBox container = new HBox(sliders, color);
        Label label = new Label("Custom color");

        sliders.setAlignment(Pos.CENTER);
        color.setAlignment(Pos.CENTER);

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        this.getChildren().addAll(container, spacer, label);
        this.setAlignment(Pos.CENTER);
    }

    void setColor(){
        circle.setFill(currentColor);
    }
}
