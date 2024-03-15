package edu.umb.cs681.hw03;

import java.util.List;

public interface DistanceMetric {
	public abstract double distance(List<Double> point1, List<Double> point2);
}
