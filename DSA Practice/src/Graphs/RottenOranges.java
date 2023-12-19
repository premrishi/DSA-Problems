package Graphs; 

public class RottenOranges {

	public static void main(String[] args) {
		int[][] grid = {
				{2,1,1},
				{1,1,0},
				{0,1,1}
		};
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 2) {
					spread(grid, i, j, 2);
				}
			}
		}
		
		int ans = calculatemintime(grid);
		System.out.println(ans);

	}
	
	public static int calculatemintime(int[][] grid) {
		int mintime = 2;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					return -1;
				}
				mintime = Math.max(mintime, grid[i][j]);
			}
		}
		return mintime-2;
	}
	
	public static void spread(int[][] grid, int i, int j, int t) {
		//base condition
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] > 1 && grid[i][j]<t) {
			return;
		}
		
		grid[i][j] = t;
		spread(grid, i, j+1, t+1);
		spread(grid, i, j-1, t+1);
		spread(grid, i+1, j, t+1);
		spread(grid, i-1, j, t+1);
	}

}
