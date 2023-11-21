package LinkedList;

public class RemoveDuplicates {
	Node head;
	public static class Node{
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		Node node = new Node(0);
		node.next = new Node(1);
		node.next.next = new Node(2);
		node.next.next.next = new Node(2);
		node.next.next.next.next = new Node(3);
		printList(node);
		removeDuplicates(node);
		printList(node);
	}
	
	public static Node removeDuplicates(Node node) {
		//temp pointer that stores the first value of the node
		Node temp = node;
		
		//while loop to traverse the entire list
		while(temp != null) {
			//pointer to store the next value that is temp.next
			Node nextNode = temp.next;
			//if the next value is not empty and the value is equal to the previous, then there is duplicate
			if(nextNode != null && nextNode.data == temp.data) {
				//so, break the temp flow and skip the duplicate and join it to the nextnode's next value
				temp.next = nextNode.next;
			} else {
				//if they are no same, then just move the temp pointer
				temp = temp.next;
			}
		}
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
