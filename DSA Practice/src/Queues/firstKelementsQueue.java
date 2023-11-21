package Queues;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a queue = 1, 2, 3, 4, 5
k=3
reverse first k-elements
​
O/P: 3, 2, 1, 4, 5
​
take the first three elemwnts push it in the stack
 */
public class firstKelementsQueue {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        //int[] arr = {1, 2, 3, 4, 5};
        int k = 3;

        for (int i=0; i<k; i++) {
            stack.push(queue.peek());
            queue.poll();
        }

        //new queue = 4, 5
        //stack = 1, 2, 3

        //after inserting in stack, insert the elements in queue
        /*
        stack = 3, 2, 1
        Queue = 4, 5
​
        After insertion = 4, 5, 3, 2, 1
         */

        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
        //Queue = 4, 5, 3, 2, 1

        for (int i=0; i< queue.size()-k; i++) {
            int x = queue.peek();
            queue.poll();
            queue.add(x);
        }

        System.out.println(queue);

    }
}