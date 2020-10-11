package medium.amazon;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class SearchPair{
	int row, col;

	public SearchPair(int row, int col) {
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
		SearchPair other = (SearchPair) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
}

public class WordSearch79 {
	public static void main(String[] args) {
		
	}
	
    public static boolean exist(char[][] board, String word) {
    	//search start
    	Deque<SearchPair> stack = new LinkedList();
    	SearchPair start = new SearchPair(0, 0);
    	stack.push(start);
    	Set<SearchPair> visited = new HashSet();
    	while(!stack.isEmpty()) {
    		SearchPair curr = stack.pop();
    		if(board[curr.row][curr.col] == word.charAt(0)) {
    			SearchPair temp = curr;
    			for(int i=1; i<word.length();++i) {
    				boolean nextExists = false;
    				if(temp.row-1>0 && board[temp.row-1][temp.col]==word.charAt(i))
    			}
    		}
    		visited.add(curr);
    		if(curr.row+1 < board.length) {
    			SearchPair nextRow = new SearchPair(curr.row+1, curr.col);
    			if(!visited.contains(nextRow)) stack.push(nextRow);
    		}
    		if(curr.col+1 < board[curr.row].length) {
    			SearchPair nextCol = new SearchPair(curr.row, curr.col+1);
    			if(!visited.contains(nextCol)) stack.push(nextCol);
    		}
    	}
    	
    	
    }
}
