package Trees;

public class countLeavesandNonleaves {

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
		
		System.out.println(leafnodes(node));
		System.out.println(nonleafnodes(node));
	}
	
	public static int leafnodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		if(node.left == null && node.right == null) {
			return 1;
		}
		
		int L = leafnodes(node.left);
		int R = leafnodes(node.right);
		int ans = L+R;
		return ans;
	}
	
	public static int nonleafnodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		if(node.left == null && node.right == null) {
			return 0;
		}
		
		int L = nonleafnodes(node.left);
		int R = nonleafnodes(node.right);
		int ans = 1+L+R;
		return ans;
	}

}
