package Practice;

public class Transpose2dmatrix {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,5,6},{7,8,9}};
		transpose2d(arr);
		}
	public static void transpose2d(int[][] arr) {
		//traverse through the array and swap the elements
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		
		//now traverse through the modified array and print them
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
		
	}

}
