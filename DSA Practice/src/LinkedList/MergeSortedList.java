package LinkedList;

// Define a class named MergeSortedList
public class MergeSortedList {

    // Define a static nested class called Node to represent a node in the linked list
    public static class Node {
        int data;        // Store an integer value in the node
        Node next;       // Reference to the next node in the linked list

        // Constructor to initialize a node with a given data value
        Node(int data) {
            this.data = data;
            this.next = null;  // Initially, the next node is set to null
        }
    }

    // The main method, where the execution of the program begins
    public static void main(String[] args) {
        // Create the first linked list (node1) with values 1, 2, 4
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(4);

        // Print the first linked list
        System.out.println("First List");
        printList(node1);
        System.out.println();

        // Create the second linked list (node2) with values 1, 3, 4
        Node node2 = new Node(1);
        node2.next = new Node(3);
        node2.next.next = new Node(4);

        // Print the second linked list
        System.out.println("Second list");
        printList(node2);
        System.out.println();

        Node ansNode;  // Declare a variable to store the result of merging

        // Call the mergeTwoSortedLinkList function to merge the two sorted linked lists
        ansNode = mergeTwoSortedLinkList(node1, node2);

        // Print the merged linked list
        System.out.println("After merging");
        printList(ansNode);
    }

    // A method to print the elements of a linked list
    public static void printList(Node node) {
        Node temp = node;

        // Traverse the linked list and print each element
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    // A method to merge two sorted linked lists and return the merged list
    public static Node mergeTwoSortedLinkList(Node node1, Node node2) {
        // Create a dummy node to serve as the starting point of the merged list
        Node head = new Node(0);
        Node ansNode = head;  // Initialize a pointer to the merged list
        Node firstNode = node1;  // Pointer to the current node in the first list
        Node secondNode = node2;  // Pointer to the current node in the second list

        // Iterate until either of the input lists is exhausted
        while (firstNode != null && secondNode != null) {
            // Compare the current nodes in both lists
            if (firstNode.data < secondNode.data) {
                ansNode.next = firstNode;  // Link the smaller node to the merged list
                firstNode = firstNode.next;  // Move to the next node in the first list
                ansNode = ansNode.next;  // Move the pointer in the merged list
            } else {
                ansNode.next = secondNode;  // Link the smaller node to the merged list
                secondNode = secondNode.next;  // Move to the next node in the second list
                ansNode = ansNode.next;  // Move the pointer in the merged list
            }
        }

        // If there are remaining nodes in the first list, link them to the merged list
        if (firstNode != null) {
            ansNode.next = firstNode;
        }

        // If there are remaining nodes in the second list, link them to the merged list
        if (secondNode != null) {
            ansNode.next = secondNode;
        }

        // Return the merged list (excluding the dummy node)
        return head.next;
    }
}
