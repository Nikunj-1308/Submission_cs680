package edu.umb.cs681.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;

public class ConvertToBWTest {

    static Image bwImg;

    @BeforeAll
    static void setupImage() {
        Image origImg = new Image(2, 2);
        origImg.setColor(0, 0, new Color(100, 150, 200));
        origImg.setColor(1, 0, new Color(50, 100, 150));
        origImg.setColor(0, 1, new Color(200, 150, 100));
        origImg.setColor(1, 1, new Color(150, 100, 5));

        bwImg = ConvertToBW.convertToBlackAndWhite(origImg);
    }

    @Test
    public void testRedBlueGreenPixelsAs150ForGetColor0And0() {
        Color expected = new Color(150, 150, 150);
        assertEquals(expected.red(), bwImg.getColor(0, 0).red());
        assertEquals(expected.green(), bwImg.getColor(0, 0).green());
        assertEquals(expected.blue(), bwImg.getColor(0, 0).blue());
    }

    @Test
    public void testRedBlueGreenPixelsAs100ForGetColor0And1() {
        Color expected = new Color(100, 100, 100);
        assertEquals(expected.red(), bwImg.getColor(1, 0).red());
        assertEquals(expected.green(), bwImg.getColor(1, 0).green());
        assertEquals(expected.blue(), bwImg.getColor(1, 0).blue());
    }

    @Test
    public void testRedBlueGreenPixelsAs150ForGetColor1And0() {
        Color expected = new Color(150, 150, 150);
        assertEquals(expected.red(), bwImg.getColor(0, 1).red());
        assertEquals(expected.green(), bwImg.getColor(0, 1).green());
        assertEquals(expected.blue(), bwImg.getColor(0, 1).blue());
    }

    @Test
    public void testRedBlueGreenPixelsAs85ForGetColor1And1() {
        Color expected = new Color(85, 85, 85);
        assertEquals(expected.red(), bwImg.getColor(1, 1).red());
        assertEquals(expected.green(), bwImg.getColor(1, 1).green());
        assertEquals(expected.blue(), bwImg.getColor(1, 1).blue());
    }
}