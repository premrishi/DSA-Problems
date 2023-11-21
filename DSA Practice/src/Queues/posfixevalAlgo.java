package Queues;
import java.util.Stack;

public class posfixevalAlgo {
    public static void main(String[] args) {
        String exp = "231*+9-";

        int ansEvaluatePostifx = postfix(exp);
        System.out.println(ansEvaluatePostifx);
    }

    public static int postfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        // Scan all characters one by one
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the scanned character is an operand
            // (number here), push it to the stack.
            if (Character.isDigit(c))
                stack.push(c - '0');

                //  If the scanned character is an operator, pop
                //  two elements from stack apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();


                // val2 <operator> val1>
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}