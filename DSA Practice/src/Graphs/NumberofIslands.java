package Graphs;

public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {
                {'1', '1', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}
        };
		
		int ans = check(grid);
		System.out.println(ans);

	}
	
	public static int check(char[][] grid){
		int count = 0;
		int height = grid.length;
		int width = grid[0].length;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '1') {
					count++;
					//call the dfs
					dfs(grid, i, j, height, width);
				}
			}
		}
		return count;
	}
	
	public static void dfs(char[][] grid, int i, int j, int height, int width) {
		//base condition for recursion
		if(i<0 || j<0 || i>=height || j>=width || grid[i][j] == '0' || grid[i][j] == '2') {
			return;
		}
		if(grid[i][j] == '1') {
			grid[i][j] = '2';
			dfs(grid, i, j+1, height, width);
			dfs(grid, i, j-1, height, width);
			dfs(grid, i+1, j, height, width);
			dfs(grid, i-1, j, height, width);
		}
	}

}
