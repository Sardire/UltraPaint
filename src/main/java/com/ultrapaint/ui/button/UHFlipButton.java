package com.ultrapaint.ui.button;

import com.ultrapaint.App;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class UHFlipButton extends UButton{
    public UHFlipButton(App app){
        super();
        setOnMouseClicked(e -> {
            WritableImage currentImage = app.mainCanva.snapshot(null, null);

            Image hFlipImage = flipHorizontal(currentImage);

            app.gc.drawImage(hFlipImage, 0, 0);
        });
    }

    public static Image flipHorizontal(Image source) {
        int width = (int) source.getWidth();
        int height = (int) source.getHeight();

        // Tạo image mới cùng kích thước
        WritableImage flipped = new WritableImage(width, height);
        PixelReader reader = source.getPixelReader();
        PixelWriter writer = flipped.getPixelWriter();

        // Với mỗi pixel (x, y) trong ảnh gốc
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Lấy pixel từ vị trí (x, y)
                Color color = reader.getColor(x, y);
                // Ghi pixel vào vị trí đối xứng (width-1-x, y)
                writer.setColor(width - 1 - x, y, color);
            }
        }
        return flipped;
    }
}
