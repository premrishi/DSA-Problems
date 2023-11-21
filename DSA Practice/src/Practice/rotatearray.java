package Practice;

import java.util.Arrays;

public class rotatearray {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		int k = 3;
		System.out.println(Arrays.toString(rotatearr(arr, k)));
	}
	
	public static int[] rotatearr(int[] arr, int k) {
		//create a new arr to store rotated array
		int rotatedarr[] = new int[arr.length];
		//traverse the ans array and fill it with roated array
		for(int i=0; i<rotatedarr.length; i++) {
			rotatedarr[i] = arr[(i+k+1)%arr.length];
		}
		return rotatedarr;
		
	}
	
}


