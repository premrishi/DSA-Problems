package Trees;


public class maxofTree {
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
		node.right.right = new Node(7);	
		node.right.right.left = new Node(8);
		
		System.out.println(maxval(node));
	}
	
	public static int maxval(Node node) {
		if(node == null) {
			return Integer.MIN_VALUE;
		}
		
		int L = maxval(node.left);
		int R = maxval(node.right);
		int ans = Math.max(Math.max(L, R), node.data);
		return ans;
		
	}

}
