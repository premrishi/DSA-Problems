package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class firstnegnumber {
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k - 1; i++) {
            if (arr[i] < 0) {
                queue.add(arr[i]);
            }
        }

        for (int i = k - 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                queue.add(arr[i]);
            }
            if (!queue.isEmpty()) {
                System.out.print(queue.peek());
                if (queue.peek() == arr[i - k + 1])
                    queue.poll();
            } else {
                System.out.print(0);
            }

            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
