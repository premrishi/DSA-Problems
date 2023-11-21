package Practice;

public class Rotate2d90 {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,5,6},{7,8,9}};
		transpose(arr);
		reverse(arr);
		printmatrix(arr);	
	}
	
	//method to transpose
	public static void transpose(int[][]arr) {
		//This is similar to transpose, but after transpose, we are reversing the array
		//Transpose the given array
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}	
		
	}
	
	//method to reverse the transposed arr
	public static void reverse(int[][] arr){
		//Now enter the logic to reverse the transposed array
				//enter the array by traversing
				for(int i = 0; i<arr.length; i++) {
					//declare two pointers L and R.
					int left = 0;
					int right = arr[0].length-1;
					//while l is less than r
					while(left<right) {
						//write a swapping to reverse
						int temp = arr[i][left];
						arr[i][left] = arr[i][right];
						arr[i][right] = temp;
						left++;
						right--;
					}
					
				}
		
	}
	
	//method to print the rotated matrix
	public static void printmatrix(int[][] arr) {
		//now traverse through the rotated matrix and print the values
				for(int i=0; i<arr.length; i++) {
					for(int j=0; j<arr[0].length; j++) {
						System.out.println(arr[i][j]);
					}
				}
		
	}

}
