package Stacks;

import java.util.Stack;

public class validParanthesis {
    public static void main(String[] args) {
        Stack<Character> stk = new Stack<>();

        String s = "{[()]}";
        //String s = "{[(])}";
        //String s = "[(])";

        String ans = "";

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stk.push(c);
            } else if (c == '}' && stk.peek() == '{' && !stk.isEmpty()) {
                stk.pop();
            } else if (c == ']' && stk.peek() == '[' && !stk.isEmpty()) {
                stk.pop();
            } else if (c == ')' && stk.peek() == '(' && !stk.isEmpty()) {
                stk.pop();
            } else {
                ans = "Not Valid";
                break;
            }
        }

        if (stk.isEmpty()) {
            ans = "Valid";
        }

        System.out.println(ans);
    }
}