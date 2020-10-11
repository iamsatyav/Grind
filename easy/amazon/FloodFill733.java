package easy.amazon;

import java.util.Arrays;
import java.util.HashSet;

class FloodPair {
	int row, col;

	public FloodPair(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FloodPair other = (FloodPair) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
}

public class FloodFill733 {
	public static void main(String[] args) {
		int[][] image = {{1,1,1},
						{1,1,0},
						{1,0,1}};
		int sr = 1, sc = 1, newColor = 2;
		floodFill(image, sr, sc, newColor);
		System.out.println(Arrays.deepToString(image));
	}
	
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	if(image[sr][sc] != newColor) {
    		int oldColor = image[sr][sc];
    		image[sr][sc] = newColor;
    		if(sr+1<image.length && image[sr+1][sc] == oldColor) floodFill(image, sr+1, sc, newColor);
    		if(sr-1>=0 && image[sr-1][sc] == oldColor) floodFill(image, sr-1, sc, newColor);
    		if(sc+1<image[0].length && image[sr][sc+1] == oldColor) floodFill(image, sr, sc+1, newColor);
    		if(sc-1>=0 && image[sr][sc-1] == oldColor) floodFill(image, sr, sc-1, newColor);
    	}
    	return image;
    }
}
