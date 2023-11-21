package Trees;


public class BalancedBinaryTree {
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
		
		
		System.out.println(isBalanceornot(node));
	}
	
	public static boolean isBalanceornot(Node node) {
		if(node == null) {
			return true;
		}
		
		int HLST = height(node.left);
		int HRST = height(node.right);
		int x = Math.abs(HLST - HRST);
		 if(x > 1) {
			 return false;
		 }
		 
		boolean Lbalance =  isBalanceornot(node.left);
		boolean Rbalance = isBalanceornot(node.right);
		boolean ans = Lbalance && Rbalance;
		return ans;
		
	}
	
	public static int height(Node node) {
		if(node == null) {
			return 0;
		}
		if(node.left == null && node.right == null) {
			return 1;
		}
		
		int l = height(node.left);
		int r = height(node.right);
		int ans = 1 + Math.max(l, r);
		
		return ans;
	
	}

}
