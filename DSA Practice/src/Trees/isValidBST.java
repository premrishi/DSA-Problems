package Trees;

public class isValidBST {
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
		// TODO Auto-generated method stub
		Node node = new Node(50);
		node.left = new Node(70);
		node.right = new Node(60);
		int initialPrev = Integer.MIN_VALUE;
		
		//System.out.println(isvalidbst(node));
		System.out.println(isvalidinorder(node, initialPrev));

	}
	
	public static boolean isvalidbst(Node node) {
		boolean ans = helper(node, Long.MIN_VALUE, Long.MAX_VALUE);
		return ans;
	}
	
	public static boolean helper(Node node, long min, long max) {
		if(node == null) {
			return true;
		}
		
		if(node.data<=min || node.data >= max) {
			return false;
		}
		
		boolean l = helper(node.left, min, node.data);
		boolean r = helper(node.right, node.data, max);
		
		boolean ans = l&&r;
		return ans;
	}
	
	public static boolean isvalidinorder(Node node, int prev) {
		if(node == null) {
			return true;
		}

		boolean l = isvalidinorder(node.left, prev);
		if(node.data <= prev) {
			return false;
		}
		
		prev = node.data;
		boolean r = isvalidinorder(node.right, prev);
		boolean ans = l&&r;
		return ans;
	}

}
