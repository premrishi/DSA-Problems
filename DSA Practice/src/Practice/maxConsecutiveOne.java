package Practice;

public class maxConsecutiveOne {
	public static void main(String[] args) {
		int arr[] = {1,1,1,0,0,0,1,1};
		int k = 1;
		System.out.println(maxconsecone(arr, k));
		
	}
	public static int maxconsecone(int arr[], int k) {
		//declare window start and window end
		int i = 0;
		int j = 0;
		//declare variable to count zeros
		int zerocount = 0;
		//declare variable to store maxconseconelength
		int maxconseclen = Integer.MIN_VALUE;
		//enter the array with window end
		while(j<arr.length) {
			//count the number of zeros in the array
			if(arr[j] == 0) {
				zerocount++;
			}
			//check if the zero count is greater than the k
			while(zerocount>k) {
				//now check if the window start has any zero
				if(arr[i] == 0) {
					//if the window zero count is greater than the allowed k, shrink the window by reducing
					//zero
					//do zero-- only if window start points to 0
					zerocount--;
				}
				//now slide the window start
				i++;
			}
			//find the maxlength 
			maxconseclen = Math.max(maxconseclen, j-i+1);
			j++;
		}
		return maxconseclen;
		
	}

}
