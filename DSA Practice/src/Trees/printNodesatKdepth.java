package Trees;

public class printNodesatKdepth {
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
		Kdepth(node, 0);
	}
	
	public static void Kdepth(Node node, int k) {
		if(node == null) {
			return;
		}
		
		if(k == 0) {
			System.out.println(node.data);
		}
		
		Kdepth(node.left, k-1);
		Kdepth(node.right, k-1);
		
	}

}
