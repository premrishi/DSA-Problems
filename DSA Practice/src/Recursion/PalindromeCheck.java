package Recursion;

public class PalindromeCheck {

    public static void main(String[] args) {
        // Check if the word "naman" is a palindrome and store the result in ansIsPalindrome.
        boolean ansIsPalindrome = isPalindrome("naman", 0, "naman".length() - 1);

        // Print whether the word is a palindrome or not.
        System.out.println(ansIsPalindrome);
    }

    // Function to check if a string is a palindrome.
    // It takes the string 's' and two pointers, 'first' and 'last'.
    public static boolean isPalindrome(String s, int first, int last) {
        // If 'first' has crossed or met 'last', we've checked all characters and it's a palindrome.
        if (first >= last) {
            return true;
        }

        // Compare the characters at 'first' and 'last' positions in the string.
        boolean lettersMatch = s.charAt(first) == s.charAt(last);

        // Recursively call the function for the inner substring (excluding first and last characters).
        boolean innerSubstringIsPalindrome = isPalindrome(s, first + 1, last - 1);

        // Combine the results to determine if the entire string is a palindrome.
        boolean isPalindrome = lettersMatch && innerSubstringIsPalindrome;

        return isPalindrome;
    }
}
