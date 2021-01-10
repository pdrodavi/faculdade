/*************************************************
 * Repository implementation using Array List to 
 * store the images.
 * 
 * Some assumptions were taken:
 *  1. Image color depth are 8 bits (Maximum value
 *  for each channel: 255). 
 *************************************************/

package image.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import space.Coordinate;
import space.Distance;

public class ArrayListRepository implements Repository {
	private List<Image> images = new ArrayList<Image>();
	private Distance distance;
	
	public ArrayListRepository(Distance distance) {
		this.distance = distance;
	}

	@Override
	public Image getImage(Coordinate coordinate) {
		Image result = null;
		
		for (Image image : images) {
			if (image.isInside(coordinate)) {
				result = image;
				break;
			}
		}
		
		return result;
	}

	@Override
	public Image[] getImage(Coordinate coordinate, int neighbours) {
		Image[] result = new Image[neighbours];
		
		double[] distances = new double[images.size()];
		
		for (int i = 0; i < images.size(); i++) {
			Image image = images.get(i);
//			distances[i] = distance.measure(coordinate, image.getCoordinate());
		}
		
		List<Double> distances_Temp = new ArrayList<Double>();
		for (int i = 0; i < distances.length; i++) {
			distances_Temp.add(distances[i]);
		}
		
		Arrays.sort(distances);
		
		for (int i = 0; i < neighbours; i++) {
			int index = distances_Temp.indexOf(distances[i]);
			result[i] = images.get(index);
		}
		
		return result;
	}

	@Override
	public void addImage(Image image) {
		if (image.hasCoordinate()) {
			this.images.add(image);
		}
	}

	@Override
	public void remImage(Image image) {
		this.images.remove(image);
	}

}
