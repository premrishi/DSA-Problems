package Algorithms;

import java.util.PriorityQueue;

public class MergePattern {

    public static int minimumComputingCost(int[] files) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Adding all file sizes to the min heap
        for (int size : files) {
            minHeap.add(size);
        }

        int totalCost = 0;

        // Merge files until there is only one file left in the heap
        while (minHeap.size() > 1) {
            int file1 = minHeap.poll(); // Remove the smallest file
            int file2 = minHeap.poll(); // Remove the next smallest file

            int mergeCost = file1 + file2; // Cost of merging these two files
            totalCost += mergeCost; // Accumulate the total cost

            minHeap.add(mergeCost); // Add the merged file back to the heap
        }

        return totalCost;
    }

    public static void main(String[] args) {
        //int[] fileSizes = {20, 30, 10, 5, 30};
        int[] fileSizes = {40, 10, 20, 15, 25, 30};


        int cost = minimumComputingCost(fileSizes);
        System.out.println("Minimum computing cost is: " + cost);
    }
}