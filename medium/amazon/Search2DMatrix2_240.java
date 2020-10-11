package medium.amazon;

class IndexNode{
	int currRow, currCol, lowCol, lowRow;

	public IndexNode(int currRow, int currCol, int lowCol, int lowRow) {
		super();
		this.currRow = currRow;
		this.currCol = currCol;
		this.lowCol = lowCol;
		this.lowRow = lowRow;
	}
}

public class Search2DMatrix2_240 {
	public static void main(String[] args) {
		int[][] matrix = {{-1},{3}};
		System.out.println(searchMatrix(matrix, 3));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0) return false;
		if(matrix.length == 1 && matrix[0].length == 0) return false;
        return searchHelper(0, matrix.length-1, matrix, target);
    }
	
	public static boolean searchHelper(IndexNode node, int[][] matrix, int target) {
		if(node.currRow-node.lowRow == node.currCol - node.lowCol) {
			if(node.currRow == node.lowRow) {
				return matrix[node.currRow][node.currCol] == target;
			}
			else if(node.currRow == matrix.length-1 
					&& node.currCol == matrix[0].length-1) {
				if(matrix[node.currRow][node.currCol] == target)
					return true;
				else if(matrix[node.currRow][node.currCol] < target)
					return false;
				else {
					return rowSearchHelper(node.lowRow, matrix.length, node.currRow, matrix, target)
							|| colSearchHelper(node.lowCol, matrix[0].length, node.currCol, matrix, target);
				}
			}
			else if(node.currRow == matrix.length-1) {
				node.currRow = node.lowRow;
				node.currCol++;
				node.lowCol = node.currCol;
				searchHelper(node, matrix, target);
			}else if(node.currCol == matrix[0].length-1) {
				
			}
		}
		
		int diagBound = Math.min(matrix.length - lowRow, matrix[0].length - lowCol);
		int pivotRow = lowRow+(diagBound-1)/2;
		int pivotCol = lowCol+(diagBound-1)/2;
		if(matrix[pivotRow][pivotCol] == target)
			return true;
		else if(matrix[pivotRow][pivotCol] < target)
			return serachHelper();
	}
	
	public static boolean rowSearchHelper(int start, int end, int row, int[][] matrix, int target) {
		if(start == end)
			return matrix[row][end] == target;
		int pivot = (start+end)/2;
		if(matrix[row][pivot] == target)
			return true;
		else if(matrix[row][pivot] < target)
			return rowSearchHelper(pivot+1, end, row, matrix, target);
		else
			return rowSearchHelper(start, pivot, row, matrix, target);
		
	}
	
	public static boolean colSearchHelper(int start, int end, int col, int[][] matrix, int target) {
		if(start == end)
			return matrix[start][col] == target;
		int pivot = (start+end)/2;
		if(matrix[pivot][col] == target)
			return true;
		else if(matrix[pivot][col] < target)
			return colSearchHelper(pivot+1, end, col, matrix, target);
		else
			return colSearchHelper(start, pivot, col, matrix, target);
	}
}
