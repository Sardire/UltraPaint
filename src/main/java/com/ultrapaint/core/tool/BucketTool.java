package com.ultrapaint.core.tool;

import com.ultrapaint.App;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.Queue;

public class BucketTool extends Tool{
    private int startX, startY;
    private WritableImage buffer;
    private Canvas canva;
    public BucketTool(App app){
        super();
        this.canva = app.mainCanva;
        this.buffer = new WritableImage((int)canva.getWidth(), (int)canva.getHeight());
    }

    @Override
    public void setBehavior(App app) {
        app.canvasPane.setOnMouseReleased(e -> {
            app.stateManager.takeSnapshot();
            startX = (int)e.getX();
            startY = (int)e.getY();
            app.mainCanva.snapshot(null, buffer);

            PixelReader reader = buffer.getPixelReader();
            PixelWriter writer = buffer.getPixelWriter();

            Color targetColor = reader.getColor(startX, startY);

            Queue<Point> queue = new LinkedList<>();
            boolean[][] visited = new boolean[(int)canva.getWidth()][(int)canva.getHeight()];

            queue.add(new Point(startX, startY));
            visited[startX][startY] = true;

            while (!queue.isEmpty()) {
                Point p = queue.poll();

                Color pixelColor = reader.getColor(p.x, p.y);
                if (pixelColor.equals(targetColor)) {
                    writer.setColor(p.x, p.y, app.currentColor);

                    // Check 4 directions
                    checkAndAdd(queue, visited, reader, p.x + 1, p.y, targetColor);
                    checkAndAdd(queue, visited, reader, p.x - 1, p.y, targetColor);
                    checkAndAdd(queue, visited, reader, p.x, p.y + 1, targetColor);
                    checkAndAdd(queue, visited, reader, p.x, p.y - 1, targetColor);
                }
            }

            app.gc.drawImage(buffer, 0, 0);
        });

        app.canvasPane.setOnMouseMoved(e -> {});

        app.canvasPane.setOnMouseDragged(e -> {});

        app.canvasPane.setOnMousePressed(e -> {});

        app.canvasPane.setOnMouseExited(e -> {
        });

        app.canvasPane.setOnMouseEntered(e -> {
        });
    }

    private void checkAndAdd(Queue<Point> queue, boolean[][] visited,
                             PixelReader reader, int x, int y, Color targetColor) {
        if (x >= 0 && x < canva.getWidth() && y >= 0 && y < canva.getHeight()
                && !visited[x][y]) {

            Color color = reader.getColor(x, y);
            if (color.equals(targetColor)) {
                queue.add(new Point(x, y));
                visited[x][y] = true;
            }
        }
    }

    private static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
}
