package Recursion;

public class countPaths {
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		int m = 3;
		int n = 3;
		System.out.println(countpaths(i, j, m, n));
	}
	
	public static int countpaths(int i, int j, int m, int n) {
		//if we have only one option to move
		if(i == m-1 && j == n-1) {
			return 1;
		}
		
		//if we have zero options to move
		if(i == m || j == n) {
			return 0;
		}
		
		// Calculate the number of paths by moving down (incrementing the row) and right (incrementing the column).
		int downmove = countpaths(i+1, j, m, n);
		int rightmove = countpaths(i, j+1, m, n);
		//adding total moves
		int moves = downmove + rightmove;
		return moves;
	}

}
