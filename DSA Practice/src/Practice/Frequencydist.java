package Practice;

public class Frequencydist {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 4, 4, 4, 6, 8 };
		printwithfreq(arr);

	}

	public static void printwithfreq(int[] arr) {
		// frequency distribution - number of occurance of each number
		// find the max value of the given number
		int maxval = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			maxval = Math.max(maxval, arr[i]);
		}
		// Now create a new array of the lenth of found max
		// add +1 so that the array does not get outbound
		int freqarr[] = new int[maxval + 1];
		// now traverse through the main array and find the index
		for (int i = 0; i < arr.length; i++) {
			// map the value present in the array as index of the fre array
			int index = arr[i];
			// now just increment the value in that index
			freqarr[index]++;
		}
		// now we have an array that has 0 aswell as the occurances
		// so just sort the freq array whose value is greater than 0
		for (int i = 0; i < freqarr.length; i++) {
			if (freqarr[i] > 0) {
				// print the index and the value in that index
				System.out.println(i + "->" + freqarr[i]);
			}
		}

	}

}
