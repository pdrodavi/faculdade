package space;

public class Coordinate {
	private double[] axis;
	
	public Coordinate(double[] axis) {
		this.axis = axis;
	}
	
	public double[] getAxis() {
		return axis;
	}
	
	public int getNumberOfDimensions() {
		return axis.length;
	}
	
	public int sum() {
		int result = 0;
		
		for (int i = 0; i < axis.length; i++) {
			result += axis[i];
		}
		
		return result;
	}

	public boolean isNear(Coordinate coordinate, double boundary, Distance distance) {
		double result = distance.measure(this, coordinate);
		
		return (result <= boundary) ? true : false;
	}
	
	public boolean equals(Coordinate coordinate) {
		boolean result = true;
		
		if (coordinate.getAxis().length != this.axis.length) {
			return false;
		}
		
		for (int i = 0; i < this.axis.length; i++) {
			double current = this.axis[i];
			double position = coordinate.getAxis()[i];
			
			if (current != position) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("[");

		for (int i = 0; i < axis.length; i++) {
			double c = axis[i];
			builder.append(i);
			builder.append(": ");
			
			builder.append(c);
			builder.append(", ");
		}
		
		builder.deleteCharAt(builder.length()-1);
		builder.deleteCharAt(builder.length()-1);
		builder.append("]");
		
		return builder.toString();
	}
}
