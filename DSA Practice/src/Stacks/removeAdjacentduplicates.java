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

        for (char ch: s.toCharArray()) {
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

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch: stack) {
            stringBuilder.append(ch);
        }

        System.out.println(stringBuilder);

    }
}
