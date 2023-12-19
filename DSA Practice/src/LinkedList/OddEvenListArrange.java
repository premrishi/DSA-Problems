package LinkedList;

public class OddEvenListArrange {
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
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		
		printList(node);
		System.out.println();
		oddEvenlist(node);
		printList(node);
		

	}
	
	public static Node oddEvenlist(Node node) {
		Node odd = node;
		Node even = odd.next;
		Node evenHead = even;
		
		while(even!= null && even.next !=null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		
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
