package edu.umb.cs681.hw03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Distance {
	public static double get(List<Double> point1, List<Double> point2) {
		return Distance.get(point1, point2, new Euclidean());
	}

	public static double get(List<Double> point1, List<Double> point2, DistanceMetric metric) {
		return metric.distance(point1, point2);
	}

	public static List<List<Double>> matrix(List<List<Double>> points) {
		return Distance.matrix(points, new Euclidean());
	};

	public static List<List<Double>> matrix(List<List<Double>> points, DistanceMetric metric) {
		int numOfPoints = points.size();
		return IntStream.range(0, numOfPoints)
				.parallel()
				.mapToObj(i -> {
					List<Double> current = points.get(i);
					return IntStream.range(0, numOfPoints)
							.mapToDouble(j -> metric.distance(current, points.get(j)))
							.boxed()
							.toList();
				})
				.toList();
	}

	private static List<List<Double>> initDistanceMatrix(int numOfPoints) {
		List<List<Double>> distanceMatrix = new ArrayList<>(numOfPoints);
		for (int i = 0; i < numOfPoints; i++) {
			Double[] vector = new Double[numOfPoints];
			Arrays.fill(vector, 0.0);
			distanceMatrix.add(Arrays.asList(vector));
		}
		return distanceMatrix;
	}

	public static List<List<Double>> generatePoints(int numOfPoints, int numOfDimensions, double randomNumberOrigin,
			double randomNumberBound) {
		List<List<Double>> points = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < numOfPoints; i++) {
			List<Double> point = random.doubles(numOfDimensions, randomNumberOrigin, randomNumberBound).boxed()
					.toList();
			points.add(point);
		}

		return points;
	}

	public static void main(String[] args) {
		int numOfPoints = 1000;
		int numOfDimensions = 100;

		double randomNumberOrigin = 10;
		double randomNumberBound = 20;

		List<List<Double>> points = generatePoints(numOfPoints, numOfDimensions, randomNumberOrigin, randomNumberBound);
		List<List<Double>> distanceMatrix = Distance.matrix(points, new Euclidean());

		// Further processing (e.g., finding the maximum distance)
		double maxDistance = distanceMatrix.stream()
				.flatMap(List::stream)
				.mapToDouble(Double::doubleValue)
				.max()
				.orElse(Double.NaN);

		System.out.println("Maximum Distance: " + maxDistance);
	}

}
