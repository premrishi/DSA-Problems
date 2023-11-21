package Recursion;

public class FirstandLastoccurance {
	public static void main(String[] args) {
		String s = "abcd";
		char element = 'c';
		firstandlast(s, -1, -1, element, 0);
	}
	
	public static void firstandlast(String s, int first, int last, char element, int index) {
		//This is the last step where we print the output
		//if the value of pointer index reaches the length of the string
		//we print the values if we meet stopping condition
		if(index == s.length()) {
				System.out.println("First = "+ first);
				//this is for edge case if the input has only one element
				last = last != -1 ? last : first;
				System.out.println("Last = "+ last);
				//this empty return statement helps us to come out of this condition
				return;
		}
		
		//this is the actual logic
		//store the character at index to char ch
		char ch = s.charAt(index);
		//check if ch is equals to the element
		if(ch == element) {
			//check if the value of first is -1
			//this is to confirm that first is not updated yet so that first remains -1
			if(first == -1) {
				//update first value to the current index
				first = index;
			} else {
				//if first is updated, the first will not be -1
				//so, consider that we found first and move to last and update last to index
				last = index;
			}
		}
		//This is the recursive call were we pass the current updated values with just index+1
		//this call acts as iterator
		firstandlast(s, first, last, element, index+1);
		
	}

}
