package edu.umb.cs681.hw04;

import java.util.List;
import java.util.stream.*;

public class Image {
    private int width;
    private int height;
    private List<List<Color>> pixels;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = IntStream.range(0, height)
                .mapToObj(i -> IntStream.range(0, width)
                        .mapToObj(j -> new Color(0, 0, 0))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public int height() {
        return height;
    }

    public int width() {
        return width;
    }

    public List<List<Color>> pixels() {
        return pixels;
    }

    public void setPixels(List<List<Color>> pixels) {
        this.pixels = pixels;
    }

    public Color getColor(int x, int y) {
        return pixels.get(y).get(x);
    }

    public void setColor(int x, int y, Color color) {
        pixels.get(y).set(x, color);
    }

    public void displayPixels() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Color pixelColor = this.getColor(j, i);
                System.out.print("(" + pixelColor.red() + ", " + pixelColor.green() + ", " + pixelColor.blue() + ") ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
