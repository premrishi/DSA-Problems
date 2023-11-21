package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {
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
		
		levelordertraversal(node);

	}
	
	public static void levelordertraversal(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node removedNode = queue.peek();
			queue.poll();
			
			System.out.println(removedNode.data);
			
			if(removedNode.left != null) {
				queue.add(removedNode.left);
			}
			
			if(removedNode.right != null) {
				queue.add(removedNode.right);
			}
		}
		
		
	}

}
