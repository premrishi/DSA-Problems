package Stacks;

/*
Given an expression - find whether it has duplicate brackets or not?
((a+b) + (c+d)) = false
(a+b) + ((c+d)) = true // ((c+d)) - outer bracket is useless
 */

import java.util.Stack;

/*
(, characters = push in stack
), pop till u find open bracket
​
((a+b) + (c+d))
​
stack = ((a+b
)
pop till (, stack = (
​
stack.isempty() = true
​
(a+b) + ((c+d))
​
stack = (a+b
stack =
stack = ((c+d
stack = (
​
if when encountering ) if peek is (, this implies it is duplicate bracket.
 */
public class duplicateBrackets {
    public static void main(String[] args) {
        String exp = "(a+b) + ((c+d))";
        Stack<Character> stack = new Stack<>();

        int flag = 0;
        for (int i=0; i<exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == ')') {
                //pop till u get '(' and check if peek is ''=> duplicatacy
                if (stack.peek() == '(') {
                    flag = 1;
                    break;
                } else {
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();  // to pop last opening bracket
                }
            } else {
                //push
                stack.push(ch);
            }
        }

        if (flag == 1) {
            System.out.println("Duplicate");
        } else {
            System.out.println("No duplicate");
        }

    }
}