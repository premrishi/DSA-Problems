package Practice;

public class Arr2dRowTraverse {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,5,6},{7,8,9}};
		arr2drow(arr);
		
	}
	public static void arr2drow(int arr[][]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]);
			}
		}
		
	}

}
