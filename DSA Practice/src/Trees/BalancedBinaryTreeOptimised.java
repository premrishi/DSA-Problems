package Trees;
import DSA.TreeBalancedClass;

public class BalancedBinaryTreeOptimised {
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(20);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.left.left = new Node(6);
		node.right.left.left.left = new Node(6);
		
		
		TreeBalancedClass ansIsBalancedOptimised = isBalancedOptimised(node);
        System.out.println(ansIsBalancedOptimised.isBalanced);

	}
	
	public static TreeBalancedClass isBalancedOptimised(Node node) {
        if (node == null) {
            TreeBalancedClass ans = new TreeBalancedClass(0, true);
            return ans;
        }

        TreeBalancedClass leftSubTree = isBalancedOptimised(node.left);
        TreeBalancedClass rightSubTree = isBalancedOptimised(node.right);

        int lHeight = leftSubTree.height;
        int rHeight = rightSubTree.height;

        boolean isLeftBalanced = leftSubTree.isBalanced;
        boolean isRightBalanced = rightSubTree.isBalanced;

        int finalHeight = 1 + Math.max(lHeight, rHeight);

        if (Math.abs(lHeight - rHeight) > 1) {
            return new TreeBalancedClass(finalHeight, false);
        }

        boolean ansIsBalanced = isLeftBalanced && isRightBalanced;
        /*
        boolean ansIsBalanced = true;
        if (Math.abs(lHeight - rHeight) > 1) {
            ansIsBalanced = false;
        }
​
        if (!isLeftBalanced || !isRightBalanced) {
            ansIsBalanced = false;
        }
         */


        return new TreeBalancedClass(finalHeight, ansIsBalanced);
    }
}


