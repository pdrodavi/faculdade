package space;

import java.util.List;

public class CosineSimilarity implements Distance {
	private double square(double o) {
		return o * o;
	}

	@Override
	public double measure(Coordinate coordinate1,
			Coordinate coordinate2) {
		double[] axis1 = coordinate1.getAxis();
		double[] axis2 = coordinate2.getAxis();

		if (axis1 == null || axis2 == null) {
			throw new RuntimeException(
			"Coordinates are null.");
		}
		if (axis1.length != axis2.length) {
			throw new UnsupportedOperationException(
					"Coordinates must have same dimensions.");
		}
		double top = 0;

		for (int i = 0; i < axis1.length; i++) {
			top = top + axis1[i] * axis2[i];
		}

		double bottom1 = 0;
		double bottom2 = 0;

		for (int i = 0; i < axis1.length; i++) {
			bottom1 = bottom1 + square(axis1[i]);
			bottom2 = bottom2 + square(axis2[i]);
		}

		bottom1 = Math.sqrt(bottom1);
		bottom2 = Math.sqrt(bottom2);
		
		if (bottom1 * bottom2 == 0) {
			return 0;
		}
		
		return top / (bottom1 * bottom2);
	}

	@Override
	public Coordinate getClosestPoint(Coordinate coordinate,
			List<Coordinate> coordinates) {
		if (coordinates.size() == 0) {
			throw new UnsupportedOperationException("Coordinates can't be empty.");
		}

		Coordinate result = coordinates.get(0);
		double closestDistance = -1;
		
		for (Coordinate currentCoordinate : coordinates) {
			double currentDistance = measure(coordinate, currentCoordinate);
			
			if (currentDistance > closestDistance) {
				closestDistance = currentDistance;
				result = currentCoordinate;
			}
		}
		
		return result;
	}

	@Override
	public int direction() {
		return -1;
	}
}
