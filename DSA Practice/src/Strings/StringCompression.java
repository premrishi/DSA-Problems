package Strings;

public class StringCompression {
	public static void main(String[] args) {
        String s = "aaabbcccddaeef";

        String ansStringCompression = stringCompression(s);
        System.out.println(ansStringCompression);
    }

    public static String stringCompression(String s) {
        String ans = s.charAt(0) +"";

        for (int i=1; i<s.length(); i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            if (curr != prev) {
                ans += curr;
            }
        }

        return ans;
    }

}
