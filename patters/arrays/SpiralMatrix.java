package patters.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4},
		                  {5, 6, 7, 8},
		                  {9,10,11,12}};
		List<Integer> res = new ArrayList();
		int nr = matrix.length;
		int nc = matrix[0].length;
		
		byte flag = 0, sin = 0;//0 for increase, 1 for decrease
		int hLower = 0, hUpper = nc-1, vLower = 0, vUpper = nr-1;
		while(hLower<=hUpper && vLower<=vUpper) {
			if(flag==0) {
				if(sin==0) {
					for(int i=hLower; i<=hUpper; i++) {
						res.add(matrix[vLower][i]);
					}
					vLower++;
				}else {
					for(int i=vLower; i<=vUpper; i++) {
						res.add(matrix[i][hUpper]);
					}
					hUpper--;
				}
				
			}else {
				if(sin==0) {
					for(int i=hUpper; i>=hLower; i--) {
						res.add(matrix[vUpper][i]);
					}
					vUpper--;
				}else {
					for(int i=vUpper; i>=vLower; i--) {
						res.add(matrix[i][hLower]);
					}
					hLower++;
				}
			}
			if(sin == 0) 
				sin++;
			else {
				sin = 0;
				flag = (byte) ((flag==0) ? 1 : 0);
			}
		}
	}
}
