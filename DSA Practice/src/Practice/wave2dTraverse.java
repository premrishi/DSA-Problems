package Practice;

public class wave2dTraverse {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,5,6},{7,8,9}};
		wave2dtraverse(arr);
	}
	public static void wave2dtraverse(int[][] arr) {
		//start with column traverse
		for(int j=0; j<arr[0].length; j++) {
			//check if the column is even or odd
			//if even, print downwards, else print upwards
			if(j%2 == 0) {
				for(int i=0; i<arr.length; i++) {
					System.out.println(arr[i][j]);
				}
			} else {
				for(int i=arr.length-1; i>=0; i--) {
					System.out.println(arr[i][j]);
				}
			}
		}
		
	}

}
