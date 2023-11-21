package LinkedList;



public class RemovefromendN {
	Node head;
	public static class Node{
		int data;
		Node next; 
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	public static void main(String[] args) {
		int n = 2;
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		printList(node);
		System.out.println();
		node = removeFromend(node, n);
		printList(node);

	}
	
	public static Node removeFromend(Node node, int n) {
		Node slow = node;
		Node fast = node;
		
		//move the fast node till n
		for(int i=0; i<n; i++) {
			fast = fast.next;
		}
		
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		
		return node;
	}
	
	public static void printList(Node node) {
		Node temp = node;
		while(temp!=null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
		
	}


}
