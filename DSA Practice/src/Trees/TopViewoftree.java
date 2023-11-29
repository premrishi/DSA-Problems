package Trees;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewoftree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Main method to test the topViewOfBinaryTree function
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        // Calling the topViewOfBinaryTree function
        topViewOfBinaryTree(node);
    }

    // Function to find and print the top view of a binary tree
    public static void topViewOfBinaryTree(Node node) {
        // Using a queue to perform level order traversal
        Queue<PairClass<Node, Integer>> queue = new LinkedList<>();
        // Storing the vertical distance of each node in a HashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Enqueue the root node with vertical distance 0
        queue.add(new PairClass<>(node, 0));

        // Perform level order traversal
        while (!queue.isEmpty()) {
            // Remove and process the front node
            PairClass<Node, Integer> pairClassRemovedNode = queue.peek();
            queue.poll();

            Node removedNode = pairClassRemovedNode.node;
            int removedNodeVerticalDistance = pairClassRemovedNode.verticalDistance;

            // Add the node to the HashMap only if its vertical distance is not present
            if (!hashMap.containsKey(removedNodeVerticalDistance)) {
                hashMap.put(removedNodeVerticalDistance, removedNode.data);
            }
            // If the vertical distance is present, do nothing

            // Enqueue the left child with a decreased vertical distance
            if (removedNode.left != null) {
                queue.add(new PairClass<>(removedNode.left, removedNodeVerticalDistance - 1));
            }

            // Enqueue the right child with an increased vertical distance
            if (removedNode.right != null) {
                queue.add(new PairClass<>(removedNode.right, removedNodeVerticalDistance + 1));
            }
        }

        // Print the values present in the HashMap (top view)
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // PairClass to represent a pair of Node and its vertical distance
    public static class PairClass<N, I extends Number> {
    	TopViewoftree.Node node;
        int verticalDistance;
        public PairClass(TopViewoftree.Node node, int verticalDistance) {
            this.node = node;
            this.verticalDistance = verticalDistance;
        }
    }
}

