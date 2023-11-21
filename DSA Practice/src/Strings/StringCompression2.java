package Strings;

public class StringCompression2 {
	public static void main(String[] args) {
        String s = "aaabbccccc";

        String ansStringCompression = stringCompression(s);
        System.out.println(ansStringCompression);
    }

    public static String stringCompression(String s) {
        String ans = s.charAt(0) + "";
        int count = 1;

        for (int i=1; i<s.length(); i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            if (curr == prev) {
                count++;
            } else {
                if (count > 1) {
                    ans += count;
                    count = 1;
                }
                ans += curr;
            }
        }

        if (count > 1) {
            ans += count;
        } 

        return ans;
    }

}
