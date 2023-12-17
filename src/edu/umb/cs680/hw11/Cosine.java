package edu.umb.cs680.hw11;

import java.util.List;

public class Cosine implements DistanceMetric{
    public double distance(List<Double> point1, List<Double> point2)
    {
        double dotProduct = 0;
		double nP1 = 0;
		double nP2 = 0;
        
		for (int i = 0; i < point1.size(); i++){
            dotProduct += point1.get(i) * point2.get(i);
			nP1 += Math.pow(point1.get(i), 2);
			nP2 += Math.pow(point2.get(i), 2);
        }

		double cosine = dotProduct / (Math.sqrt(nP1) * Math.sqrt(nP2));
		return 1 - cosine;
    }
}