package Recursion;

public class moveX {
    public static void main(String[] args) {
        // Define the input string and its length.
        String s = "axhjsxxjsiwzx";
        int l = s.length();

        // Call the 'movex' function to process the string.
        movex(s, 0, l);
    }

    // Recursive function to move all 'x' characters to the end of the string.
    public static void movex(String s, int index, int length) {
        // If the current index is beyond the length of the string, we're done.
        if (index >= length) {
            return;
        }

        // Get the character at the current index.
        char current = s.charAt(index);

        // If the current character is not 'x', print it.
        if (current != 'x') {
            System.out.print(current);
        }

        // Recursively call the 'movex' function for the next character (increment index).
        movex(s, index + 1, length);

        // If the current character is 'x', print it (effectively moving 'x' characters to the end).
        if (current == 'x') {
            System.out.print(current);
        }

        // Return to the previous function call.
        return;
    }
}
