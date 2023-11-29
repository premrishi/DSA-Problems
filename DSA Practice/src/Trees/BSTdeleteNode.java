package Trees;

public class BSTdeleteNode {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static void main(String[] args) {
            Node node = new Node(20);
            node.left = new Node(15);
            node.right = new Node(30);
            node.left.left = new Node(10);
            node.left.right = new Node(17);
            node.right.left = new Node(25);
            node.right.right = new Node(40);
            node.left.left.left = new Node(2);
            node.left.left.right = new Node(12);
            node.left.right.left = new Node(16);
            node.left.right.right = new Node(19);

            preorder(node);
            System.out.println();
            node = deleteNode(node, 15);
            preorder(node);
        }

        public static void preorder (Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preorder(node.left);
                preorder(node.right);
            }
        }

        public static Node deleteNode (Node node, int key) {

            if (node == null) {
                return null;
            }

            if (key < node.data) {
                node.left = deleteNode(node.left, key);
            } else if (key > node.data) {
                node.right = deleteNode(node.right, key);
            } else {
                if (node.left == null) { // leaf with one child
                    return node.right;
                } else if (node.right == null) {  // leaf with one child
                    return node.left;
                }

                // leaf with 2 children
                //calculate min from the RST
                Node ansminNode = minNode(node.right);
                node.data = ansminNode.data;
                node.right = deleteNode(node.right, node.data);
            }

            return node;
        }

        public static Node minNode (Node node) {
            while (node.left != null) {
                node = node.left;
            }

            return node;
        }
    }
}
