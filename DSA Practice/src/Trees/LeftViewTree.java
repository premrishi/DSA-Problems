package Trees;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {
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
		
		leftView(node);

	}
	
	public static void leftView(Node node) {
		Queue<Node> que = new LinkedList<>();
		que.add(node);
		while(!que.isEmpty()) {
			int quesize = que.size();
			for(int i=0; i<quesize; i++) {
			Node removedNode = que.peek();
			que.poll();
			
			if(i == 0) {
			System.out.print(removedNode.data);
			}
			
			if(removedNode.left != null) {
				que.add(removedNode.left);
			}
			
			if(removedNode.right != null) {
				que.add(removedNode.right);
			}
			
			}
			
		}
		
		
	}

}
