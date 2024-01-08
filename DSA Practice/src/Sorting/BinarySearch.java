package Sorting;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//return the index
		int[] arr = {1,2,3,6,9,22};
		int target = 6;
		System.out.println(bs(arr, target));
		System.out.println(recursive(arr, target, 0, arr.length));
	}
	
	public static int bs(int[] arr, int target) {
		int start = 0;
		int end = arr.length-1;
		//base condtion
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] ==  target) {
				return mid;
			}
			
			else if(arr[mid]<target) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return -1;
	}
	
	public static int recursive(int[] arr, int target, int start, int end) {
		//base condition
		if(start>end) {
			return -1;
		}
		
		int mid = start + (end - start)/2;
		if(arr[mid] ==  target) {
			return mid;
		} else if(arr[mid]>target) {
			return recursive(arr, target, start, mid-1);
		} else {
			return recursive(arr, target, mid+1, end);
		}
	}

}
