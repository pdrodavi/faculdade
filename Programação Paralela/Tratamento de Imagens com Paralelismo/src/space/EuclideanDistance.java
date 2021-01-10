package space;

import java.util.List;

public class EuclideanDistance implements Distance {
	private double square(double o) {
		return o * o;
	}
	
	public double measure(Coordinate coordinate1, Coordinate coordinate2) {
		double[] axis1 = coordinate1.getAxis();
		double[] axis2 = coordinate2.getAxis();
		double result = 0;

		if (axis1 == null || axis2 == null) {
			throw new UnsupportedOperationException("Axis can't be null.");
		}
		
		if (axis1.length != axis2.length) {
			throw new UnsupportedOperationException("Coordinates must have same dimensions.");
		}

		for (int i = 0; i < axis1.length; i++) {
			result += square(axis1[i] - axis2[i]);
		}
		
		return Math.sqrt(result);
	}

	@Override
	public Coordinate getClosestPoint(Coordinate coordinate,
			List<Coordinate> coordinates) {
		if (coordinates.size() == 0) {
			throw new UnsupportedOperationException("Coordinates can't be empty.");
		}

		Coordinate result = coordinates.get(0);
		double closestDistance = Double.MAX_VALUE;
		
		for (Coordinate currentCoordinate : coordinates) {
			double currentDistance = measure(coordinate, currentCoordinate);
			
			if (currentDistance < closestDistance) {
				closestDistance = currentDistance;
				result = currentCoordinate;
			}
		}
		
		return result;
	}

	@Override
	public int direction() {
		return 1;
	}
}
