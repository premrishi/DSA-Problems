package Stacks;

import java.util.Stack;

/*
Return smallest possible integer after removing k digits
 */
public class removeKdigits {
    public static void main(String[] args) {
        //String num = "1432219";
        //String num = "4321";
        //String num = "10200";
        String num = "14301620";
        int k = 4;
        //int k = 2;
        //Ans = 1219

        /*
        Get all the possible numbers and find the smallest out of it.
​
        We want the smallest number, for smallest number - we need smaller number in the starting
​
        1432219
​
        1
        14
        143 = 13 ; k=2
        132 = 12 ; k=1
        122 = 12 ; k=0
        1219 = ans
​
​
        1
        14
        now for 3, if we get a smaller number after bigger number, remove the bigger number and decrease the k
​
        123
        for 2 remove 3 and add 2, k = 2-1=1
        142
​
        142
        2 even though 2 is same as 2, we will remove 2.
        so, 142, k=1-1=0
​
​
         */

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            //checking for peaks, if there is any peak, we need to normalise it ie remove that peak
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }

            //if stack.isempty and c=='0' => then do not push
            if (!stack.isEmpty() || c != '0')
                stack.push(c);
        }


        // if number is 1234 => all ascending
        while (!stack.isEmpty() && k > 0) {
            k--;
            stack.pop();
        }

        //popping the elements from the stack and pushing it in stringbuilder
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        //reversing the stringbuilder
        String str = result.reverse().toString();

        System.out.println(str);

    }
}