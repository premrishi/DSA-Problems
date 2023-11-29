package Trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTreetraversal {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);


        List<List<Integer>> ansZigZagTraversal = zigZagTraversal(node);
        System.out.println(ansZigZagTraversal);
    }

    public static List<List<Integer>> zigZagTraversal(Node node) {


        //Do a level order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean flag = true;
        List<List<Integer>> ansList = new ArrayList<>();

        /*
        //Add in leetcode
        if (root == null) {
            return ansList;
        }
         */


        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i=0; i<queueSize; i++) {
                Node removedNode = queue.peek();
                queue.poll();

                if (flag == true) { //print in the same order
                    levelList.add(removedNode.data);
                } else {  // put in reverse order
                    levelList.add(0, removedNode.data);
                }


                if (removedNode.left != null) {
                    queue.add(removedNode.left);
                }

                if (removedNode.right != null) {
                    queue.add(removedNode.right);
                }
            }

            ansList.add(levelList);
            flag = !flag;
        }

        return ansList;
    }
}
