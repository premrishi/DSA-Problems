package LinkedList;



public class DeleteSecondmiddle {
	
	//creating node template class
	Node head;
	public static class Node{
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
		
	}
	 

	public static void main(String[] args) {
		DeleteSecondmiddle linkedlist = new DeleteSecondmiddle();
		createlist(linkedlist);
		printlist(linkedlist);
		linkedlist.head = deletesecondmiddle(linkedlist.head);
		printlist(linkedlist);
		
		
	}
	
	public static Node deletesecondmiddle(Node node) {
		Node fast = node.next;
		Node slow = node;
		Node prev = node;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = slow.next;
		
		return node;
		
		
		
	}
	
	public static void createlist(DeleteSecondmiddle linkedlist) {
		linkedlist = insertlist(linkedlist, 1);
		linkedlist = insertlist(linkedlist, 2);
		linkedlist = insertlist(linkedlist, 3);
		linkedlist = insertlist(linkedlist, 4);
		linkedlist = insertlist(linkedlist, 5);
		linkedlist = insertlist(linkedlist, 6);
		
	}
	
	public static DeleteSecondmiddle insertlist(DeleteSecondmiddle linkedlist, int data) {
		Node newnode = new Node(data);
		if(linkedlist.head == null) {
			linkedlist.head = newnode;
			newnode.next = null;
		} else {
			Node temp = linkedlist.head;
			 while(temp.next != null) {
				 temp = temp.next;
			 }
			 temp.next = newnode;
			 newnode.next = null;
		}
		
		return linkedlist;
		
		
	}
	
	public static void printlist(DeleteSecondmiddle linkedlist) {
		Node temp = linkedlist.head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;	
		}
		System.out.println("null");
		
	}

}
