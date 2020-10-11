package medium.amazon;

public class NumberOfIslands200 {
	public static void main(String[] args) {
		char[][]  grid = {{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}};
		int count = 0;
		for(int i=0; i<grid.length; ++i) {
			for(int j=0; j<grid[0].length; ++j) {
				if(grid[i][j] == '1') {
					count++;
					trigger_dfs(grid, i, j);
				}
			}
		}
		System.out.println(count);
	}
	
	public static void trigger_dfs(char[][] grid, int x, int y) {
		if(grid[x][y] == '0')
			return;
		grid[x][y] = '0';
		if(x-1>=0) trigger_dfs(grid, x-1, y);
		if(y-1>=0) trigger_dfs(grid, x, y-1);
		if(x+1<=grid.length) trigger_dfs(grid, x+1, y);
		if(y+1<=grid[0].length) trigger_dfs(grid, x, y+1);
	}
}
