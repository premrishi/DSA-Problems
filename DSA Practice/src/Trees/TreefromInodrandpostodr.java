package Trees;

import java.util.HashMap;

public class TreefromInodrandpostodr {
    public static int preorderIndex = 0;
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

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};


        // to fetch the index in inroder, so that we can bifurcate our Left and right
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<preorder.length; i++) {
            hashMap.put(inorder[i], i);
        }

        Node root = createTree(0, preorder.length-1, preorder, hashMap);
        preorderTraversal(root);
    }

    public static Node createTree(int start, int end, int[] preorder, HashMap<Integer, Integer> hashMap) {
        if (start > end) {
            return null;
        }

        Node root = new Node(preorder[preorderIndex]);  // root will be the first element of preorder
        // get the index of root from inorder, the elements to the left of it in indorer[] will form left subtree, and right to it will form right subtree
        int index = hashMap.get(preorder[preorderIndex]);
        preorderIndex++;

        root.left = createTree(start, index-1, preorder, hashMap);
        root.right = createTree(index+1, end, preorder, hashMap);

        return root;
    }

    public static void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
}
