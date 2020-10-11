package medium.amazon;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Tuple{
	int x, y, level;
	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Tuple(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.level = level;
	}
}


public class BfsDfsTryOut {
	public static void main(String[] args) {
		int[][] grid = {{1,2,3,4,5},
						{6,7,8,9,10},
						{11,12,13,14,15},
						{16,17,18,19,20},
						{21,22,23,24,25}};
		printGridDFSTry1(grid, 0,0);
		//printGridDFSTry3(grid);
	}
	
	public static void printGridDFSTry1(int[][] grid, int x, int y) {
		if(x<0 || y<0 || x>4 || y>4)
			return;
		if(grid[x][y] < 0)
			return;
		System.out.print(grid[x][y]+", ");
		grid[x][y] = -1;
		printGridDFSTry1(grid, x, y+1);
		printGridDFSTry1(grid, x+1, y);
		printGridDFSTry1(grid, x, y-1);
		printGridDFSTry1(grid, x-1, y);
		
	}
	
	public static void printGridDFSTry2(int[][] grid) {
		Deque<Tuple> ms = new LinkedList<Tuple>();
		ms.push(new Tuple(0,0));
		while(!ms.isEmpty()) {
			Tuple curr = ms.pop();
			System.out.print(grid[curr.x][curr.y] + ", ");
			grid[curr.x][curr.y] = -1;
			if(curr.x-1 >= 0 && grid[curr.x-1][curr.y] > 0) ms.push(new Tuple(curr.x-1, curr.y));
			if(curr.y-1 >= 0 && grid[curr.x][curr.y-1] > 0) ms.push(new Tuple(curr.x, curr.y-1));
			if(curr.x+1 <= 4 && grid[curr.x+1][curr.y] > 0) ms.push(new Tuple(curr.x+1, curr.y));
			if(curr.y+1 <= 4 && grid[curr.x][curr.y+1] > 0) ms.push(new Tuple(curr.x, curr.y+1));
		}
	}
	
	public static void printGridDFSTry3(int[][] grid) {
		Deque<Tuple> ms = new LinkedList<Tuple>();
		ms.push(new Tuple(0,0));
		int ncount = 0;
		while(!ms.isEmpty()) {
			Tuple curr = ms.pop();
			if(grid[curr.x][curr.y] > 0) {
				System.out.print(grid[curr.x][curr.y] + ", ");
				grid[curr.x][curr.y] = -1;
			}
			else {
				ncount++;
				continue;
			}
			
//			if(curr.x-1 >= 0) ms.push(new Tuple(curr.x-1, curr.y));
//			if(curr.y-1 >= 0) ms.push(new Tuple(curr.x, curr.y-1));
//			if(curr.x+1 <= 4) ms.push(new Tuple(curr.x+1, curr.y));
//			if(curr.y+1 <= 4) ms.push(new Tuple(curr.x, curr.y+1));
			if(curr.x-1 >= 0 && grid[curr.x-1][curr.y] > 0) ms.push(new Tuple(curr.x-1, curr.y));
			if(curr.y-1 >= 0 && grid[curr.x][curr.y-1] > 0) ms.push(new Tuple(curr.x, curr.y-1));
			if(curr.x+1 <= 4 && grid[curr.x+1][curr.y] > 0) ms.push(new Tuple(curr.x+1, curr.y));
			if(curr.y+1 <= 4 && grid[curr.x][curr.y+1] > 0) ms.push(new Tuple(curr.x, curr.y+1));
		}
		System.out.println("\n -1 count  : "+ ncount);
	}
	
	public static void printGridBFSTry1(int[][] grid) {
		Comparator<Tuple> mycom = new Comparator<Tuple>() {
			@Override
			public int compare(Tuple o1, Tuple o2) {
				if(o1.level > o2.level)
					return 1;
				return 0;
			}
		};
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(mycom);
		pq.add(new Tuple(4, 4, 1));
		int ncount = 0;
		while(!pq.isEmpty()) {
			Tuple curr = pq.poll();
			if(grid[curr.x][curr.y]>=0) {
				System.out.print("("+grid[curr.x][curr.y]+ ", "+curr.level+"), ");
				grid[curr.x][curr.y] = -1;
			}else {
				ncount++;
				continue;
			}
			if(curr.x-1 >= 0) pq.add(new Tuple(curr.x-1, curr.y, curr.level+1));
			if(curr.y-1 >= 0) pq.add(new Tuple(curr.x, curr.y-1, curr.level+1));
			if(curr.x+1 <= 4) pq.add(new Tuple(curr.x+1, curr.y, curr.level+1));
			if(curr.y+1 <= 4) pq.add(new Tuple(curr.x, curr.y+1, curr.level+1));
		}
		System.out.println("\n -1 count  : "+ ncount);
	}
}
