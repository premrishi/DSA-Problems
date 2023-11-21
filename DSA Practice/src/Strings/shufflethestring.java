package Strings;

public class shufflethestring {
	public static void main(String[] args) {
		String s = "codeleet";
		int[] arr = {4,5,6,7,0,2,1,3};	
		System.out.println(shuffle(arr, s));
	}
	
	public static char[] shuffle(int[] arr, String s) {
		//convert the given string to character array
		char[] charray = s.toCharArray();
		//declare pointer i as 0
		int i = 0;
		//enter the array
		while(i<arr.length) {
			//fetch the character
			
			//declare index from the array
			int index = arr[i];
			
			//if the pointer is not equal to index
			if(i != index) {
				//swap the element
				char temp = charray[i];
				charray[i] = charray[index];
				charray[index] = temp;
				
				//now swap the index
				int tempindex = arr[i];
				arr[i] = arr[index];
				arr[index] = tempindex;
			} else {
				i++;
			}
			
		}
		return charray;
		
	}

}
