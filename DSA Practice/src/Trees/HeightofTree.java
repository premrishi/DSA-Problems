package Trees;

public class HeightofTree {
	
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
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);	
		node.right.right.left = new Node(8);
		
		
		System.out.println(heightwithRoot(node));
		System.out.println(heightwithoutroot(node));
	}
	
	public static int heightwithRoot(Node node) {
		if(node == null) {
			return 0;
		}
		
		int l = heightwithRoot(node.left);
		int r = heightwithRoot(node.right);
		int ans  = 1 + Math.max(l, r);
		return ans;
	}
	
	public static int heightwithoutroot(Node node) {
		
		if(node == null) {
			return 0;
		}
		if(node.left == null && node.right == null) {
			return 0;
		}
		
		int l = heightwithoutroot(node.left);
		int r = heightwithoutroot(node.right);
		int ans  = 1 + Math.max(l, r);
		return ans;
		
	}

}
