package Trees;


public class MirrorofTree {
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
		
		
		preorder(node);
		System.out.println();
		mirror(node);
		preorder(node);

	}
	
	public static void preorder(Node node) {
		if(node!= null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
		
	}
	
	public static void mirror(Node node) {
		if(node == null) {
			return;
		}
		
		mirror(node.left);
		mirror(node.right);
		
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

}
