package medium.amazon;

public class RotateMatrix48 {
	public static void main(String[] args) {
		int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		rotate(matrix);
	}
	
	public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int start=0, end=n-1;
        while(start<end){
            rotateOutside(matrix, start++, end--);
        }
    }
    
    public static void rotateOutside(int[][] matrix, int start, int end){
        int n = end-start+1;
        for(int i=0; i<n-1; ++i){
            int row = start, col = start+i, temp=matrix[row][col];
            for(int j=0; j<3; j++){
                matrix[row][col] = matrix[n-1-col][row];
                int tempRow =row;
                row = start+n-1-col; 
                col = start+tempRow;
            }
            matrix[row][col] = temp;
        }
    }
}
