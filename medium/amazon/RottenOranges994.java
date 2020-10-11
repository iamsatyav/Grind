package medium.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Tup{
	int x, y;
	public Tup(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}

public class RottenOranges994 {
	public static void main(String[] args) {
		int[][] grid = {{2,1,1},
						{1,1,0},
						{0,1,1}};
		System.out.println(orangesRotten(grid));
	}
	
	//0-empty, 1-fresh, 2-rotten
	public static int orangesRotten(int[][] grid) {
		 List<Tup> rottenList = new ArrayList();
		 int emptyCells = 0;
		 int totalCells = grid.length * grid[0].length;
		 for(int i=0; i<grid.length; ++i) {
			 for(int j=0; j<grid[0].length; ++j) {
				 if(grid[i][j] == 2)
					 rottenList.add(new Tup(i, j));
				 else if(grid[i][j] == 0)
					 emptyCells++;
			 }
		 }
		 
		 if(rottenList.isEmpty()) {
			 return (emptyCells == totalCells) ? 0 : -1;
		 }
		 
		 int res = 0;
		 while(rottenList.size() + emptyCells < totalCells) {
			 boolean moreRotten = false;
			 int startIndex = 0;
			 int currSize = rottenList.size();
			 for(int i=startIndex; i< currSize; ++i) {
				 Tup ea = rottenList.get(i);
				 if(ea.x-1 >= 0 && grid[ea.x-1][ea.y] != 0 && grid[ea.x-1][ea.y] != 2) {  
					 grid[ea.x-1][ea.y] = 2;
					 moreRotten = rottenList.add(new Tup(ea.x-1, ea.y));
				 }
				 if(ea.y-1 >= 0 && grid[ea.x][ea.y-1] != 0 && grid[ea.x][ea.y-1] != 2) {  
					 grid[ea.x][ea.y-1] = 2;
					 moreRotten = rottenList.add(new Tup(ea.x, ea.y-1));
				 }
				 if(ea.x+1 < grid.length && grid[ea.x+1][ea.y] != 0 && grid[ea.x+1][ea.y] != 2) {  
					 grid[ea.x+1][ea.y] = 2;
					 moreRotten = rottenList.add(new Tup(ea.x+1, ea.y));
				 }
				 if(ea.y+1 < grid[0].length && grid[ea.x][ea.y+1] != 0 && grid[ea.x][ea.y+1] != 2) {  
					 grid[ea.x][ea.y+1] = 2;
					 moreRotten = rottenList.add(new Tup(ea.x, ea.y+1));
				 }
				 startIndex = i;
			 }
			 if(!moreRotten) return -1;
			 res++;
		 }
		 return res;
	}
}
