package Trees;

public class fullNodes {
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
		node.right.right.right = new Node(8);
		node.right.right.left = new Node(9);
		
		System.out.println(fullnodes(node));
	}
	
	public static int fullnodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		int l = fullnodes(node.left);
		int r = fullnodes(node.right);
		int ans = l + r + (node.left != null && node.right != null ? 1 : 0);
		
		return ans;
		
	}

}
