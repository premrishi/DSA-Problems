package DSA;

import java.util.ArrayList;
import java.util.Arrays;

public class arrList {
	public static void main(String[] args){
		//1d array
		ArrayList<Integer> test = new ArrayList<Integer>();
		//2d array
		ArrayList<ArrayList<Integer>> test2 = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(i++);
            }
            test2.add(row);
        }
		test.add(1);
		test.add(4);
		test.add(1);
		test.add(7);
		test.add(9);
		test.add(12);
		System.out.println(test);
		//Converting ArrayList to Array
		int[] arr = new int[test.size()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = test.get(i);
		}
		System.out.println(Arrays.toString(arr));
		
		//Converting 2d arrayList to 2d array
		int rows = test2.size();
		int columns = test2.get(0).size();
		int[][] array = new int[rows][columns];
		for(int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				array[i][j] = test2.get(i).get(j);
			}
		}
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j]);
            }
            
        }
		
	}

}
