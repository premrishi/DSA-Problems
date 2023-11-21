package Queues;

/*
Given a queue of integers of even length,
rearrange the elements by interleaving the first half of the queue with the second half of the queue.
​
Input :  1 2 3 4
Output : 1 3 2 4
​
Input : 11 12 13 14 15 16 17 18 19 20
Output : 11 16 12 17 13 18 14 19 15 20
​
​
break the queue into two parts,
then the O/P formed will be :-
first elen=ment from firsrt half then from second half
​
I/P: 1 2 3 4
O/P: 1 3 2 4
​
1. insert reversed first half in stack
2. then put first pointer in stack and second pointer in queue.
1 2 3 4
stack = 2 1
queue = 3 4
​
3. put the data from stack in queue
queue =
​
​
I/P: 11 12 13 14 15 16 17 18 19 20
O/P:
​
11 12 13 14 15
16 17 18 19 20
​
O/P: 11 16 12 17 13 18 14 19 15 20
​
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleavetheFirstHalf {
    public static void main(String[] args) {


        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        int n=4;

        //Step -1 => putting first half in stack
        for (int i=0; i<n/2; i++) {
            stack.push(queue.peek());
            queue.poll();
        }

        //Step - 2 => Putting the data back in queue
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }

        //Step -3 => Remove first half of queue and push it back in the queue
        for (int i=0; i<n/2; i++) {
            int x = queue.peek();
            queue.poll();
            queue.add(x);
        }

        //Step - 4 => Removing first half from queue and put it in stack
        for (int i=0; i<n/2; i++) {
            stack.push(queue.peek());
            queue.poll();
        }


        //Step - 5 Taking two pointers and making the queue
        /*
        stack = 2 1
        queue = 3, 4
​
        resQueue = 3 4 1 => 4 1 3
        stack = 2
​
        resQueue = 4 1 3 2 => 1 3 2 4
         */
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
            queue.add(queue.peek());
            queue.poll();
        }

        System.out.println(queue);

    }
}
