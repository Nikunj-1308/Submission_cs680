package edu.umb.cs680.hw11;

import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CosineTest{
    @Test
    public void verifyDistanceBetweenPoint1As1And7And14AndPoint2As3And6And9(){
        List<Double> point1 = Arrays.asList(1.0, 7.0, 14.0);
        List<Double> point2 = Arrays.asList(3.0, 6.0, 9.0);
        double expected = 0.02872259835782942;
        double actual = new Cosine().distance(point1, point2);
        Assertions.assertEquals(expected, actual);
    }
}