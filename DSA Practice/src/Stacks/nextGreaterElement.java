package Stacks;

import java.util.Arrays;
import java.util.Stack;

/*
Find the next greater element that lies to the right of the array
​
I/P: 18, 7, 6, 12, 15
O/P: -1, 12, 15, 15, -1
 */
/*
Smaller or equal elements can be pushed on the stack.
 */
public class nextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {18, 7, 6, 12, 15};

        int[] ansArr = new int[arr.length];
        Arrays.fill(ansArr, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            int curr = arr[i];

            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && curr > arr[stack.peek()]) {
                    //pop and update
                    int index = stack.pop();
                    ansArr[index] = curr;
                }
                stack.push(i);
            }
        }

        System.out.println(Arrays.toString(ansArr));
    }

}