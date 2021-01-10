package space;

public class CoordinateOutOfSpaceException extends Exception {
	private static final long serialVersionUID = 1L;

	public CoordinateOutOfSpaceException() {
	}

	public CoordinateOutOfSpaceException(String arg0) {
		super(arg0);
	}

	public CoordinateOutOfSpaceException(Throwable arg0) {
		super(arg0);
	}

	public CoordinateOutOfSpaceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
