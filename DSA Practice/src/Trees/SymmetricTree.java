package Trees;

public class SymmetricTree {
	
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
        node.right = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(4);
        node.right.left = new Node(4);
        node.right.right = new Node(3);
        
        
        System.out.println(checkSymmetric(node));

	}
	
	public static boolean checkSymmetric(Node node) {
		if(node == null) {
			return true;
		}
		
		return isMirror(node.left, node.right);
	}
	
	public static boolean isMirror(Node p, Node q) {
		if(p == null && q == null) {
			return true;
		}
		
		if(p == null || q == null) {
			return false;
		}
		
		boolean l = p.data == q.data;
		boolean r = isMirror(p.left, q.right);
		boolean s = isMirror(p.right, q.left);
		
		boolean ans = l&&r&&s;
		return ans;
		
	}

}
