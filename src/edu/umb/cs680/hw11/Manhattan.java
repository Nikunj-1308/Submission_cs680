package edu.umb.cs680.hw11;

import java.util.List;

public class Manhattan implements DistanceMetric{
    
	public double distance(List<Double> point1, List<Double> point2){
        
		double sum = 0;	
		for (int i = 0; i < point1.size(); i++){
            if(point1.get(i) - point2.get(i) < 0){
				double temp = -1.0 * (point1.get(i) - point2.get(i));
				sum += temp;
			}
			else{
				sum = sum + (point1.get(i) - point2.get(i));
			}
        }
        return sum;
    }
}