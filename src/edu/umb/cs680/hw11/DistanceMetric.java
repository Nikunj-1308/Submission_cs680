package edu.umb.cs680.hw11;

import java.util.List;

public interface DistanceMetric {
	 public abstract double distance(List<Double> point1, List<Double> point2);
}
