package image.mapping;

import space.Coordinate;

public interface Repository {
	Image getImage(Coordinate coordinate);
	Image[] getImage(Coordinate coordinate, int kNeighbours);
	void addImage(Image image);
	void remImage(Image image);
}
