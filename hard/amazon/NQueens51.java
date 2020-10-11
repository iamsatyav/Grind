package hard.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class QueenCell {
	int row, col;
	public QueenCell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
}

class QueenNode {
	int currCol;
	List<QueenCell> positions;
	public QueenNode(int currCol, List<QueenCell> positions) {
		super();
		this.currCol = currCol;
		this.positions = positions;
	}
}

public class NQueens51 {
	
	static int _n;
	static List<List<String>> result;
	static List<String> placeholder;
	static List<String> dummy;
	
	public static void main(String[] args) {
		solveNQueens(3);
		for(List<String> ea: result) {
			System.out.println("");
			for(String eb: ea) {
				System.out.println(eb);
			}
		}
	}
	
    public static List<List<String>> solveNQueens(int n) {
    	if(n==0) return null;
    	_n = n;
    	
    	placeholder = new ArrayList();
    	dummy = new ArrayList();
    	for(int i=0; i<_n;++i) {
    		String temp = "";
    		for(int j=0; j<_n; ++j) {
    			temp += (i==j)?"Q":".";
    		}
    		placeholder.add(temp);
    		dummy.add("");
    	}
    	result = new ArrayList();
        helper(new QueenNode(0, null));
        return result;
    }
    
    public static void helper(QueenNode node) {
    	if(node.currCol == _n) {
			List<String> currRes = new ArrayList(dummy);
    		for(QueenCell ea: node.positions) {
    			currRes.set(ea.row, placeholder.get(ea.col));
    		}
    		result.add(currRes);
    	}
    	
    	for(int i=0; i<_n; ++i) {
    		boolean isPossible = true;
    		if(node.positions == null) {
    			List<QueenCell> newPositions = new ArrayList();
				newPositions.add(new QueenCell(i, node.currCol));
				helper(new QueenNode(node.currCol+1, newPositions));
    		}else {
	    		for(QueenCell ea: node.positions) {
	    			if(ea.row == i || Math.abs(ea.row-i) == Math.abs(ea.col-node.currCol)) {
	    				isPossible = false;
	    				break;
	    			}
	    		}
	    		if(isPossible) {
		    		List<QueenCell> newPositions = new ArrayList(node.positions);
					newPositions.add(new QueenCell(i, node.currCol));
					helper(new QueenNode(node.currCol+1, newPositions));
				}
    		}
    	}
    }
}
