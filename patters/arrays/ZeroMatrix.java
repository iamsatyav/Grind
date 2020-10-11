package patters.arrays;

import java.util.Arrays;

public class ZeroMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		for(int i=0;i<matrix.length; ++i){
            for(int j=0;j<matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
		System.out.println(Arrays.deepToString(matrix));
        
        for(int i=0;i<matrix.length; ++i){
            if(matrix[i][0] == 0){
                for(int j=0;j<matrix[0].length;++j){
                    matrix[i][j] =0;
                }
            }
        }
        
        for(int i=0;i<matrix[0].length; ++i){
            if(matrix[0][i] == 0){
                for(int j=0;j<matrix.length;++j){
                    matrix[j][i] =0;
                }
            }
        }
	}
}
