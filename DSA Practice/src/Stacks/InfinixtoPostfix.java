package Stacks;
import java.util.Stack;

public class InfinixtoPostfix {
	public static void main(String[] args) {
		// String exp = "a+b*c";
		// String exp = "a*b+c";
		// String exp = "a*b+(c-d)";
		// String exp = "a+(b-c)";
		String exp = "a+b-c";
		String ansInfixToPostfix = infixToPostfix(exp);
		System.out.println(ansInfixToPostfix);
	}

	public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        String res = "";
        for (int i=0; i<exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                //if c is an operand => simple O/P
                res += exp.charAt(i);
            } else if (c == '(') {
                //left parenthesis => push it into the stack
                stack.push(c);
            } else if (c == ')') {
                // if right parenthesis => pop till u get left parenthesis
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.peek();
                    stack.pop();
                }
                //we need to pop '(' too
                stack.pop();
            } else {
                //if c is an operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    res += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid parenthesis";
            }
            res += stack.peek();
            stack.pop();
        }

       return res;
    }

	public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;

    }
}
