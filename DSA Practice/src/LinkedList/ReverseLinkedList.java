package LinkedList;

public class ReverseLinkedList {
    Node head; // Declare a reference to the head of the linked list.

    public static class Node {
        int data;
        Node next;
        // Each element (node) in the linked list has an integer value (data) and a reference to the next element (next).

        public Node(int data) {
            this.data = data;
            this.next = null;
            // Initialize a node with the provided data and set the next reference to null.
        }
    }

    public static void main(String[] args) {
        Node node = new Node(0); // Create the first node with data 0.
        node.next = new Node(1); // Create the second node with data 1 and connect it to the first node.
        node.next.next = new Node(2); // Create the third node with data 2 and connect it to the second node.
        node.next.next.next = new Node(3); // Create the fourth node with data 3 and connect it to the third node.
        node.next.next.next.next = new Node(4); // Create the fifth node with data 4 and connect it to the fourth node.

        printList(node); // Print the linked list before reversing it.

        node = reverseList(node); // Reverse the linked list and store the new head of the list in the 'node' variable.

        printList(node); // Print the reversed linked list.
    }

    public static Node reverseList(Node node) {
        Node curr = node; // Initialize a pointer 'curr' to the current node.
        Node prev = null; // Initialize a pointer 'prev' to null.
        Node nextNode; // Initialize a pointer 'nextNode' for the next node.

        while (curr != null) {
            nextNode = curr.next; // Store the next node in 'nextNode.'
            curr.next = prev; // Reverse the 'next' reference of the current node to point to the previous node.
            prev = curr; // Move 'prev' to the current node.
            curr = nextNode; // Move 'curr' to the next node.
        }

        return prev; // Return the new head of the reversed list.
    }

    public static void printList(Node node) {
        Node temp = node; // Initialize a temporary pointer to the head of the linked list.

        while (temp != null) {
            System.out.print(temp.data); // Print the data of the current node.
            temp = temp.next; // Move to the next node in the list.
        }
    }
}
