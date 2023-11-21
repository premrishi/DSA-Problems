package Practice;

public class Arr2dCoulumnTraverse {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,5,6},{7,8,9}};
		arr2dcolumn(arr);
		
	}
	public static void arr2dcolumn(int[][] arr) {
		for(int j=0; j<arr[0].length; j++) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i][j]);
			}
		}
		
	}

}
