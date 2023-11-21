package Practice;

public class Spiral2dmatrix {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,5,6},{7,8,9}};
		spiralmatrix(arr);
	}
	
	public static void spiralmatrix(int[][] arr) {
		//declare the direction 
		int direction = 0;
		//initialize the top, bottom, left, right
		int top = 0;
		int bottom = arr.length-1;
		int left = 0;
		int right = arr[0].length-1;
		//set while condition
		while(top<=bottom && left<=right) {
			//print left to right elements if direction is 0
			if(direction == 0) {
				for(int i = left; i<=right; i++) {
					System.out.println(arr[top][i]);
				}
				//move the top to next place
				top++;
			}
			
			//print top to bottom elements if direction is 1
			if(direction == 1) {
				for(int i=top; i<=bottom; i++) {
					System.out.println(arr[i][right]);
				}
				//move right to next place
				right--;
			}
			
			//print right to left elements if direction is 2
			if(direction == 2) {
				for(int i=right; i>= left; i--) {
					System.out.println(arr[bottom][i]);
				}
				//move bottom to next place
				bottom--;
			}
			
			//print bottom to top elements if direction is 3
			if(direction == 3) {
				for(int i = bottom; i>= top; i--) {
					System.out.println(arr[i][left]);
				}
				//move left to next place
				left++;
			}
			
			//increment direction and limit it to 4 by mod
			direction = (direction+1)%4;
			
			
		}
		
	}

}
