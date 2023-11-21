package Practice;

public class search2dmatrix {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3},
				       {4,5,6},
				       {7,8,9}};
		int target = 9;
		search2d(arr, target);
	}
	
	public static void search2d(int[][] arr, int target) {
		//declare the pointers
		int i=0;
		int j = arr[0].length-1;
		int flag = 0;
		//traverse through the array
		while(i<arr.length && j>=0) {
			//if the target is fount, return it
			if(target == arr[i][j]) {
				flag = 1;
				System.out.println("found at"+i+" "+j);
				break;
			} else if(arr[i][j]<target) {
				i++;
			} else {
				j--;
			}
			
			
		}
		if(flag == 0) {
			System.out.println("Target not found");
		}
		
	}

}
