package patters.arrays;

public class RotateMatrixClockwise {
	public static void main(String[] args) {
		int[][] matrix = {{1, 2},
		                {3,4}};
		rotate(matrix);
	}
	
	public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n==0 || n==1) return;
        int[] holder = new int[n];
        int k = n-1;
        while(k > 1 || (n==2 && k==n-1)){
            int startIdx = (n-k)/2;
            for(int a=0; a<4; a++){
                switch(a){
                    case 0:
                        swapForwardColumn(n, k, startIdx, k,
                                    scoopForwardRow(n, k, startIdx, startIdx, holder, matrix),
                                         matrix);
                        break;
                    case 1:
                        swapBackwardRow(n, k, k, k, holder, matrix);
                        break;
                    case 2:
                        swapBackwardColumn(n, k, k, startIdx, holder, matrix);
                        break;
                    default:
                        swapForwardRow(n, k, startIdx, startIdx, holder, matrix);
                        break;
                }
            }
            k = k==n-1? k-1 : k-2;
        }
    }
    
    public static int[] scoopForwardRow(int n, int k, int start, int row, int[] holder, int[][] matrix){
        for(int i=start; i<=k; i++){
            holder[Math.abs(i)] = matrix[row][i];
        }
        return holder;
    }
    
    public static void swapForwardRow(int n, int k, int start, int row, int[] holder, int[][] matrix){
        holder[start] = holder[k];
        for(int i=start+1; i<=k; i++){
            int temp = holder[i];
            holder[i] = matrix[row][i];
            matrix[row][i] = temp;
        }
    }
    
    public static void swapForwardColumn(int n, int k, int start, int col, int[] holder, int[][] matrix){
        holder[start] = holder[k];
        for(int i=start+1; i<=k; i++){
            int temp = holder[i];
            holder[i] = matrix[i][col];
            matrix[i][col] = temp;
        }
    }
    
    public static void swapBackwardRow(int n, int k, int start, int row, int[] holder, int[][] matrix){
        holder[(n-k)/2] = holder[start];
        for(int i=start-1; i>=(n-k)/2; i--){
        	if(k-((n-k)/2)==1 || k-((n-k)/2)==0) {
        		int temp = holder[k];
                holder[k] = matrix[row][i];
                matrix[row][i] = temp;
        	}else {
	            int temp = holder[k-i];
	            holder[k-i] = matrix[row][i];
	            matrix[row][i] = temp;
            }
        }
    }
    
    public static void swapBackwardColumn(int n, int k, int start, int col, int[] holder, int[][] matrix){
        holder[(n-k)/2] = holder[start];
        for(int i=start-1; i>=(n-k)/2; i--){
        	if(k-((n-k)/2)==1 || k-((n-k)/2)==0) {
	            int temp = holder[k];
	            holder[k] = matrix[i][col];
	            matrix[i][col] = temp;
            }else {
            	int temp = holder[k-i];
                holder[k-i] = matrix[i][col];
                matrix[i][col] = temp;
            }
        }
    }
}
