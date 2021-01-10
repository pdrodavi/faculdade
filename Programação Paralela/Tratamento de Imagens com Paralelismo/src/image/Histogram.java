package image;

import java.awt.image.Raster;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Jama.Matrix;

public class Histogram {
	private Map<Integer, Integer> rColorMap = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> gColorMap = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> bColorMap = new HashMap<Integer, Integer>();
	protected int[] rHistogram;
	protected int[] gHistogram;
	protected int[] bHistogram;
	protected int maxValue;

	public Histogram(Raster raster) {
		for (int i = 0; i < raster.getHeight(); i++) {
			for (int j = 0; j < raster.getWidth(); j++) {
				int[] pixelChannels = new int[3];
				pixelChannels = raster.getPixel(i, j, pixelChannels);

				// Red channel
				Integer value = rColorMap.get(pixelChannels[0]);
				if (value == null) {
					value = 0;
				}

				rColorMap.put(pixelChannels[0], ++value);

				// Green channel
				value = gColorMap.get(pixelChannels[1]);
				if (value == null) {
					value = 0;
				}

				gColorMap.put(pixelChannels[1], ++value);

				// Blue channel
				value = bColorMap.get(pixelChannels[2]);
				if (value == null) {
					value = 0;
				}

				bColorMap.put(pixelChannels[2], ++value);
			}
		}

		rHistogram = createHistogram(rColorMap);
		gHistogram = createHistogram(gColorMap);
		bHistogram = createHistogram(bColorMap);
	}

	public Histogram(Matrix[] matrixes, int maxValue) {
		if (matrixes.length != 3
				|| matrixes[0].getColumnDimension() != matrixes[1]
						.getColumnDimension()) {
			throw new RuntimeException("Only RGB channels are supported.");
			// TODO criar uma exceção para isso
		}
		
		this.maxValue = maxValue;
		for (int i = 0; i < matrixes[0].getRowDimension(); i++) {
			for (int j = 0; j < matrixes[0].getColumnDimension(); j++) {
				// Red channel
				int color = (int) matrixes[0].get(i, j);

				if (color > maxValue) {
					color = maxValue;
				}

				Integer value = rColorMap.get(color);
				if (value == null) {
					value = 0;
				}

				rColorMap.put(color, ++value);

				// Green channel
				color = (int) matrixes[1].get(i, j);

				if (color > maxValue) {
					color = maxValue;
				}

				value = gColorMap.get(color);
				if (value == null) {
					value = 0;
				}

				gColorMap.put(color, ++value);

				// Blue channel
				color = (int) matrixes[2].get(i, j);

				if (color > maxValue) {
					color = maxValue;
				}

				value = bColorMap.get(color);
				if (value == null) {
					value = 0;
				}

				bColorMap.put(color, ++value);
			}
		}

		rHistogram = createHistogram(rColorMap);
		gHistogram = createHistogram(gColorMap);
		bHistogram = createHistogram(bColorMap);
	}

	private int[] createHistogram(Map<Integer, Integer> colorMap) {
		int[] result = new int[256];

		Arrays.fill(result, 0);

		Integer[] keys = new Integer[colorMap.size()];
		keys = colorMap.keySet().toArray(keys);
		Arrays.sort(keys);

		for (int i = 0; i < keys.length; i++) {
			int double1 = keys[i];
			Integer value = colorMap.get(double1);

			result[i] = value;
		}

		return result;
	}

	public Map<Integer, Integer> getRColorMap() {
		return rColorMap;
	}

	public Map<Integer, Integer> getGColorMap() {
		return gColorMap;
	}

	public Map<Integer, Integer> getBColorMap() {
		return bColorMap;
	}

	public String toString() {
		String result = "";

		result += "### R ###\n\n";
		for (int i = 0; i < rHistogram.length; i++) {
			result += i + ": " + rHistogram[i] + "\n";
		}

		result += "\n### G ###\n\n";
		for (int i = 0; i < gHistogram.length; i++) {
			result += i + ": " + gHistogram[i] + "\n";
		}

		result += "\n### B ###\n\n";
		for (int i = 0; i < bHistogram.length; i++) {
			result += i + ": " + bHistogram[i] + "\n";
		}

		return result;
	}
}
