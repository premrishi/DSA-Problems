package Stacks;

import java.util.Stack;

/*
abbaca
​
Stack = ab
 */

public class removeAdjacentduplicates {
	public static void main(String[] args) {
        String s = "abbaca";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (ch == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i));
        }

    }
}
