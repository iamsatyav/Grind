package medium.amazon;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class SLNode{
	int row, col, num;

	public SLNode(int row, int col, int num) {
		super();
		this.row = row;
		this.col = col;
		this.num = num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + num;
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
		SLNode other = (SLNode) obj;
		if (col != other.col)
			return false;
		if (num != other.num)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
}

class SLQPair{
	SLNode node;
	int level;
	public SLQPair(SLNode node, int level) {
		super();
		this.node = node;
		this.level = level;
	}
}

public class SnakesAndLadders909 {
	public static void main(String[] args) {
//		int[][] board = {{-1,-1,-1,-1,-1,-1},
//						{-1,-1,-1,-1,-1,-1},
//						{-1,-1,-1,-1,-1,-1},
//						{-1,35,-1,-1,13,-1},
//						{-1,-1,-1,-1,-1,-1},
//						{-1,15,-1,-1,-1,-1}};
		int[][] board = {{-1,1,2,-1},
						{2,13,15,-1},
						{-1,10,-1,-1},
						{-1,6,2,8}};
		System.out.println(snakesAndLadders(board));
	}
	
	public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int maxNum = n*n;
        if(n==1 || n==2) return 1;
        Deque<SLQPair> aq = new LinkedList();
        Set<SLNode> visited = new HashSet();
        visited.add(new SLNode(n-1, 0, 1));
        for(int i=1; i<=6; ++i) {
        	SLNode curr = getNode(i+1, n);
        	if(board[curr.row][curr.col] != -1) {
        		curr = getNode(board[curr.row][curr.col], n);
        	}
        	aq.add(new SLQPair(curr, 1));
        }
        
        while(!aq.isEmpty()) {
        	SLQPair curr = aq.poll();
        	visited.add(curr.node);
        	if(curr.node.num == maxNum)
        		return curr.level;
        	for(int i=1; i<=6; ++i) {
        		if(curr.node.num + i<0 || curr.node.num + i> maxNum)
        			continue;
            	SLNode temp = getNode(curr.node.num + i, n);
            	if(board[temp.row][temp.col] != -1) {
            		temp = getNode(board[temp.row][temp.col], n);
            	}
            	if(!visited.contains(temp))
            		aq.add(new SLQPair(temp, curr.level + 1));
            }
        }
        return -1;
    }
	
	public static SLNode getNode(int num, int n){
		int row = n - (num-1)/n -1;
		int col = ((row+n)%2==0)? (n-(num-1)%n-1) : (num-1)%n;
		return new SLNode(row, col, num);
	}
}
