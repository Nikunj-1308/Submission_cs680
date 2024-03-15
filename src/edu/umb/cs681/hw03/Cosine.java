package edu.umb.cs681.hw03;

import java.util.List;
import java.util.stream.IntStream;

public class Cosine implements DistanceMetric {
	public double distance(List<Double> point1, List<Double> point2) {
		double dotProduct = IntStream.range(0, point1.size())
				.mapToDouble(i -> point1.get(i) * point2.get(i))
				.sum();

		double normP1 = Math.sqrt(IntStream.range(0, point1.size())
				.mapToDouble(i -> Math.pow(point1.get(i), 2))
				.sum());

		double normP2 = Math.sqrt(IntStream.range(0, point2.size())
				.mapToDouble(i -> Math.pow(point2.get(i), 2))
				.sum());

		double cosine = dotProduct / (normP1 * normP2);
		return 1 - cosine;
	}
}
