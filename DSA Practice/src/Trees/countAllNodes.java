package Trees;

public class countAllNodes {
	
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
		
		System.out.println(number(node));

	}
	
	public static int number(Node node) {
		if(node == null) {
			return 0;
		}
		int l = number(node.left);
		int r = number(node.right);
		int ans  = l+r+1;
		return ans;
		
	}

}
