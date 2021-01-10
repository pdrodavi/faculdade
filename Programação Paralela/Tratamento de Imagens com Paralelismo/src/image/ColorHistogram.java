package image;

import java.awt.image.Raster;

import Jama.Matrix;

public class ColorHistogram extends Histogram {
	private int[][][] histogram;
	private int numOfBins;
	
	public ColorHistogram(Raster raster, int numOfBins) {
		super(raster);
		this.numOfBins = numOfBins;
	}

	public ColorHistogram(Matrix[] matrixes, int maxValue, int numOfBins) {
		super(matrixes, maxValue);
		this.numOfBins = numOfBins;
	}

}
