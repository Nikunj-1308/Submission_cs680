package edu.umb.cs680.hw11;

import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class EuclideanTest{
    @Test
    public void verifyDistanceTestWithPoint1As1And1And4AndPoint2As7And8And9() {
        List<Double> point1 = Arrays.asList(1.0, 1.0, 1.0);
        List<Double> point2 = Arrays.asList(7.0, 8.0, 9.0);
        double actual = new Euclidean().distance(point1, point2);
		double expected = Math.sqrt(149);
        Assertions.assertEquals(expected, actual);
    }
}