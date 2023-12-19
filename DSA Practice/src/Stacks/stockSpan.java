package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {
        //int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] arr = {60, 70};
        int[] span = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        //span of first day is 0.
        span[0] = 1;

        //pushing first element onto my stack
        stack.push(0);

        for (int i=1; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                span[i] = i+1;
            } else {
            	
                span[i] = i-stack.peek();
            }

            stack.push(i);
        }

        System.out.println(Arrays.toString(span));
    }
}