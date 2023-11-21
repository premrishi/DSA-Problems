package DSA;

public class llprac {
	
	static Node head;
	public static class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		insertatbeg(node, 5);
		printlist(node);
		
	}
	
	public static void printlist(Node node) {
		Node temp = node;
		while(temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}
	
	public static void insertatbeg(Node node, int data) {
		Node nodee = new Node(data);
		nodee.next = head;
		head = nodee;
	}

}
