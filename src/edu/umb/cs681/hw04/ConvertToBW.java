package edu.umb.cs681.hw04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToBW {

    public static Image convertToBlackAndWhite(Image origImg) {
        List<List<Color>> bwPixels = new ArrayList<>();

        // Iterate through each pixel in the original image
        for (int i = 0; i < origImg.height(); i++) {
            List<Color> row = new ArrayList<>();
            for (int j = 0; j < origImg.width(); j++) {
                // Get the color of the current pixel
                Color pixelColor = origImg.getColor(j, i);

                // Calculate the average of red, green, and blue values
                int avg = (pixelColor.red() + pixelColor.green() + pixelColor.blue()) / 3;

                // Create a new color with the average value
                Color bwColor = new Color(avg, avg, avg);
                row.add(bwColor);
            }
            bwPixels.add(row);
        }

        // Create a new image with the black and white pixels
        Image bwImage = new Image(origImg.width(), origImg.height());
        bwImage.setPixels(bwPixels);

        // Return the new black and white image
        return bwImage;
    }

    public static void main(String[] args) {
        // Create a small 2x2 image with initial pixel colors
        Image origImg = new Image(2, 2);
        origImg.setColor(0, 0, new Color(100, 150, 200));
        origImg.setColor(1, 0, new Color(50, 100, 150));
        origImg.setColor(0, 1, new Color(200, 150, 100));
        origImg.setColor(1, 1, new Color(150, 100, 5));

        // Display original pixel colors
        System.out.println("Original Pixel Colors:");
        origImg.displayPixels();

        // Convert the image to black and white
        Image bwImg = convertToBlackAndWhite(origImg);

        // Display black and white pixel colors after conversion
        System.out.println("Black and White Pixel Colors:");
        bwImg.displayPixels();
    }

}