package Algorithms;

import java.util.PriorityQueue;

public class OptimalMergePattern {
    public static void main(String[] args) {

        //int size = 3;
        //int[] files = {10, 20, 30};

        int size = 6;
        int[] files = {40, 10, 20, 15, 25, 30};

        int ansMinRecords = minRecords(files, size);
        System.out.println(ansMinRecords);
    }

    public static int minRecords(int[] files, int size) {
        //create a min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i=0; i<size; i++) {
            priorityQueue.add(files[i]);
        }

        int count  = 0;
        while (priorityQueue.size() > 1) {
            //pop the two smallest elements from heap
            int temp = priorityQueue.poll() + priorityQueue.poll();
            count += temp;

            //after merging the records add it into the min heap again
            priorityQueue.add(temp);
        }

        return count;
    }
}