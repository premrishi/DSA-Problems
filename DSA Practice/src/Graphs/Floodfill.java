package Graphs;

public class Floodfill {

	public static void main(String[] args) {
		int sr = 1;
		int sc = 1;
		int color = 2;
		int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
		
		int[][] ans = check(image, sr, sc, color);
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] check(int[][] image, int sr, int sc, int color) {
		if(image[sr][sc] == color) {
			return image;
		}
		int originalcolor = image[sr][sc];
		fill(image, sr, sc, originalcolor, color);
		return image;
	}
	
	public static void fill(int[][] image, int sr, int sc, int originalcolor, int color) {
		//base comdition
		if(sr<0 || sc<0 || sr>= image.length || sc>= image[0].length || image[sr][sc] != originalcolor) {
			return;
		}
		image[sr][sc] = color;
		fill(image, sr, sc+1, originalcolor, color);
		fill(image, sr, sc-1, originalcolor, color);
		fill(image, sr+1, sc, originalcolor, color);
		fill(image, sr-1, sc, originalcolor, color);
	}

}
