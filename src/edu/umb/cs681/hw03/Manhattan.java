package edu.umb.cs681.hw03;

import java.util.List;
import java.util.stream.IntStream;

public class Manhattan implements DistanceMetric {
	public double distance(List<Double> point1, List<Double> point2) {
		return IntStream.range(0, point1.size())
				.mapToDouble(i -> Math.abs(point1.get(i) - point2.get(i)))
				.sum();
	}
}
