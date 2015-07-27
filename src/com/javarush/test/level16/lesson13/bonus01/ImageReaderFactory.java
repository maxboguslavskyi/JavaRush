package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory {

    public static ImageReader getReader(ImageTypes imageTypes) {

        try {
            if (imageTypes.equals(ImageTypes.JPG)) {
                return new JpgReader();
            }
            if (imageTypes.equals(ImageTypes.BMP)) {
                return new BmpReader();
            }
            if (imageTypes.equals(ImageTypes.PNG)) {
                return new PngReader();
            }
            return null;
        } catch (Exception e) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

    }
}
