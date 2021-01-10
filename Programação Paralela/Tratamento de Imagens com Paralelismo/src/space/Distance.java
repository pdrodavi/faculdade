package space;

import java.util.List;

public interface Distance {
	//Measure the distance between two coordinates
	double measure(Coordinate coordinate1, Coordinate coordinate2);
	
	//Find the closest point among a list of coordinates
	Coordinate getClosestPoint(Coordinate coordinate, List<Coordinate> coordinates);
	
	//If the similarity increases when the distance decreases, direction = 1
	//Eg.: Euclidean distance
	//If the similarity increases when the distance increases, direction = -1
	//Eg.: Cosine similarity
	int direction();
}
