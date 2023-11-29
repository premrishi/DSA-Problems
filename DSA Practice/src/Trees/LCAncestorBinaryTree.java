package Trees;


public class LCAncestorBinaryTree {
	
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
		int a = 3;
		int b = 6;
		
		Node ans = LCA(node, a, b);
		System.out.println(ans.data);
	}
	
	public static Node LCA(Node node, int a, int b) {
	    // Base case: If the current node is null, return null
	    if(node == null) {
	        return null;
	    }

	    // If the current node's data matches either of the given values (a or b),
	    // then this node is the Lowest Common Ancestor (LCA)
	    if(node.data == a || node.data == b) {
	        return node;
	    }

	    // Recursively search for the LCA in the left and right subtrees
	    Node l = LCA(node.left, a, b);
	    Node r = LCA(node.right, a, b);

	    // If one of the subtrees returns null, the LCA is in the other subtree
	    if(l == null) {
	        return r;
	    }

	    if(r == null) {
	        return l;
	    }

	    // If both left and right subtrees have valid LCA nodes, then the current node is the LCA
	    return node;
	}


}
