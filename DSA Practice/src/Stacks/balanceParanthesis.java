package Stacks;

import java.util.Stack;

public class balanceParanthesis {
    public static void main(String[] args) {

        /*
        I/P: ((((
        O/P: 2
​
        It can be reversed like ()() or (()) not an issue, just need to find out the minimum number of brackets
​
         I/P: ))((
         O/P: 2
         ()()
​
         Algortihm:
         Traverse through the string, if you find an open bracket, push it into the stack.
​
​
         After the stack creation do this :-
         Then pop two elements from stack, if they both are same => (,( or ),), increment the counter by 1,
         because if they are (( or )), they can be balanced just by reversing one bracket.
​
         ( - push into the stack
         ) - if peek = ) pop, if stack.isEmpty(), push into the stack.
         */

        //String str2 = "((((";
        //String str2 = ")(((";
        String str2 = ")()(";
        //String str2 = "()((";
        int ansMin = minimumReversal(str2);
        System.out.println(ansMin);
    }

    public static int minimumReversal(String s) {
        /*
        ((((
        ( - push
        ) - peek == ( => pop
            isEmpty() => push
​
        )(((
        O/P: 2
​
        stack = )(((
        (( => 1
        )( => 3
​
        )()(
​
        )(
         */

        int count = 0;
        Stack<Character> stack = new Stack<>();

        if (s.length() %2 !=0)
            // it can never be balanced
            return -1;


        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            //)((( , s = )(,
            //pop two elements from stack
            char x1 = stack.pop();
            char x2 = stack.pop();

            //if (x1 == '(' && x2 == '(' || x1 == ')' && x2 == ')')
            if (x1 == x2){
                count++;
            }
            // )( in this case we have to reverse both the brackets, so add 2 to count.
            else if (x1 == '(' && x2 == ')'){
                count+= 2;
            }
        }
        return count;
    }
}
