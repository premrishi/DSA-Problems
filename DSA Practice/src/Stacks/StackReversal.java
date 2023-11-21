package Stacks;
import java.util.Stack;

public class StackReversal {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {


        stack.push(1);
        stack.push(2);
        stack.push(3);
        //stack.push(4);
        //stack.push(5);

        System.out.println("Original stack :" +stack);

        rev();
        System.out.println("Reversed stack : " +stack);
    }

    public static void rev() {
        if (stack.size() > 0) {
            int stackPeek = stack.peek();
            stack.pop();
            rev();

            insertAtBottom(stackPeek);
        }
    }

    public static void insertAtBottom(int stackPeek) {
        if (stack.isEmpty()) {
            stack.push(stackPeek);
        } else {
            int peek = stack.peek();
            stack.pop();
            insertAtBottom(stackPeek);
            stack.push(peek);
        }

    }
}
