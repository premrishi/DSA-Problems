package Sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,8,0,11,2};
		int l = 0;
		int r = arr.length-1;
		mergesort(arr, l, r);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergesort(int[] arr, int l, int r) {
		if(l<r) {
			int mid = l + (r-l)/2;
			mergesort(arr, l, mid);
			mergesort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}
	
	public static void merge(int[] arr, int l, int mid, int r) {
		int[] list1 = new int[mid - l + 1];
        int[] list2 = new int[r - mid];

        // copied the elements of first list into first copy list
        for (int i=0; i<list1.length; i++) {
            list1[i] = arr[i + l];
        }

        // copied the elements of second list into second copy list
        for (int i=0; i<list2.length; i++) {
            list2[i] = arr[i+mid+1];
        }
        
      //merge two sorted arrays logic
        int p1 = 0;
        int p2 = 0;

        int k = l;
        while (p1 < list1.length && p2 < list2.length) {
            if (list1[p1] <= list2[p2]) {
                arr[k] = list1[p1];
                p1++;
            } else {
                arr[k] = list2[p2];
                p2++;
            }

            k++;
        }

        while (p1 < list1.length) {
            arr[k] = list1[p1];
            p1++;
            k++;
        }

        while (p2 < list2.length) {
            arr[k] = list2[p2];
            k++;
            p2++;
        }
	}

}
