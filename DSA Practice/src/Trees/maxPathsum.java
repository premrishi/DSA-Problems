package Trees;

public class maxPathsum {
    public static int result = Integer.MIN_VALUE;
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

    public static void main(String[] args) {
        Node node = new Node(-1);
        node.left = new Node(1);
        node.right = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.left.left = new Node(8);
        node.left.left.right = new Node(4);
        node.left.right.right = new Node(-10);

        int ansMaxPathSum = helper(node);
        System.out.println(ansMaxPathSum);
    }

    public static int helper(Node node) {
        maxPathSum(node);
        return result;
    }

    public static int maxPathSum(Node node) {
        if (node == null) {
            return 0;
        }

        int l = maxPathSum(node.left);
        int r = maxPathSum(node.right);

        // temp is something to be returned => temp signifies the maximum sum if the node is in path of max sum
        int temp = Math.max((Math.max(l, r) + node.data), node.data);

        // ans is the value if that particular node is the root of max path sum
        int ans = Math.max(temp, l + r + node.data);
        result = Math.max(result, ans);

        return temp;
    }
}
