package LinkedList;

public class MiddleofList {
	
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
		MiddleofList linkedlist = new MiddleofList();
		createlist(linkedlist);
		printlist(linkedlist);
		
		System.out.println(middleofthelist(linkedlist.head));
		
	}
	
	public static int middleofthelist(Node head) {
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (slow != null) {
		    return slow.data;
		} else {
		    return -1;
		}
		
	}
	
	public static void createlist(MiddleofList linkedlist) {
		linkedlist = insertlist(linkedlist, 1);
		linkedlist = insertlist(linkedlist, 2);
		linkedlist = insertlist(linkedlist, 3);
		linkedlist = insertlist(linkedlist, 4);
		linkedlist = insertlist(linkedlist, 5);
		linkedlist = insertlist(linkedlist, 6);
		
	}
	
	public static MiddleofList insertlist(MiddleofList linkedlist, int data) {
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
	
	public static void printlist(MiddleofList linkedlist) {
		Node temp = linkedlist.head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;	
		}
		System.out.println("null");
		
	}

}
