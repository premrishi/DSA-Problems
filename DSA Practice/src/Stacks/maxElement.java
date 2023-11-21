package Stacks;

import java.util.Stack;

public class maxElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 10, 9};

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(arr[0]);
        stack2.push(arr[0]);

        for (int i=1; i< arr.length; i++) {
            stack1.push(arr[i]);

            if (stack2.peek() < arr[i]) {
                stack2.push(arr[i]);
            } else {
                stack2.push(stack2.peek());
            }
        }

        System.out.println(stack2.peek());
    }
}