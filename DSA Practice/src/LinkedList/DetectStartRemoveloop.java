package LinkedList;

public class DetectStartRemoveloop {
    // Define the main class for detecting and removing a loop in a linked list.
    Node head; // Declare a reference to the head of the linked list.

    public static class Node {
        int data; // Each node in the linked list stores an integer value.
        Node next; // Each node has a reference to the next node in the list.

        Node(int data) {
            this.data = data; // Initialize the data of a node with the provided value.
            this.next = null; // Initially, the next reference is set to null.
        }
    }

    public static void main(String[] args) {
        // The main function, the entry point of the program.
        Node node = new Node(1); // Create the first node with data 1.
        node.next = new Node(2); // Create the second node with data 2 and connect it to the first node.
        node.next.next = new Node(3); // Create the third node with data 3 and connect it to the second node.
        node.next.next.next = new Node(4); // Create the fourth node with data 4 and connect it to the third node.
        node.next.next.next.next = new Node(5); // Create the fifth node with data 5 and connect it to the fourth node.
        node.next.next.next.next.next = node.next; // Create a loop by connecting the last node to the second node.

        System.out.println(detectloop(node)); // Check if a loop exists and print the result (true or false).
        Node ansNode = meetingpoint(node); // Find the node where the loop starts and store it in ansNode.
        System.out.println(ansNode.data); // Print the data value of the node where the loop starts.
        removeLoop(node); // Remove the loop from the linked list.
        printList(node); // Print the elements of the modified linked list.

    }

    public static boolean detectloop(Node node) {
        // Function to detect if a loop exists in the linked list.
        Node slow = node; // Initialize a slow pointer to the head of the linked list.
        Node fast = node; // Initialize a fast pointer to the head of the linked list.

        while (fast != null && fast.next != null) {
            // Loop while the fast pointer can move forward in the list.
            slow = slow.next; // Move the slow pointer one step at a time.
            fast = fast.next.next; // Move the fast pointer two steps at a time.

            if (slow == fast) {
                // If the slow and fast pointers meet, there's a loop.
                return true;
            }
        }
        return false; // If no loop is found, return false.
    }

    public static Node meetingpoint(Node node) {
        // Function to find the node where the loop starts.
        Node slow = node; // Initialize a slow pointer to the head of the linked list.
        Node fast = node; // Initialize a fast pointer to the head of the linked list.

        while (fast != null && fast.next != null) {
            // Loop while the fast pointer can move forward in the list.
            slow = slow.next; // Move the slow pointer one step at a time.
            fast = fast.next.next; // Move the fast pointer two steps at a time.

            if (slow == fast) {
                // If the slow and fast pointers meet, it means there's a loop, so break out of the loop.
                break;
            }
        }

        Node startingpoint = node; // Initialize a new pointer at the head of the list.
        Node meetingpoint = fast; // The meeting point is where the loop is detected.

        while (meetingpoint != startingpoint) {
            // Move both pointers one step at a time until they meet at the start of the loop.
            meetingpoint = meetingpoint.next;
            startingpoint = startingpoint.next;
        }
        return meetingpoint; // Return the node where the loop starts.
    }

    public static Node removeLoop(Node node) {
        // Function to remove the loop from the linked list.
        Node slow = node; // Initialize a slow pointer to the head of the linked list.
        Node fast = node; // Initialize a fast pointer to the head of the linked list.

        while (fast != null && fast.next != null) {
            // Loop while the fast pointer can move forward in the list.
            slow = slow.next; // Move the slow pointer one step at a time.
            fast = fast.next.next; // Move the fast pointer two steps at a time.

            if (slow == fast) {
                // If the slow and fast pointers meet, it means there's a loop, so break out of the loop.
                break;
            }
        }

        Node temp = node; // Create a temporary pointer at the head of the list.

        while (temp.next != fast.next) {
            // Find the node just before the start of the loop.
            temp = temp.next;
            fast = fast.next;
        }

        fast.next = null; // Remove the loop by breaking the connection.
        return node; // Return the modified linked list.
    }

    public static void printList(Node node) {
        // Function to print the elements of the linked list.
        Node temp = node; // Initialize a temporary pointer to the head of the linked list.
        while (temp != null) {
            System.out.print(temp.data); // Print the data of the current node.
            temp = temp.next; // Move to the next node in the list.
        }
        System.out.println("null"); // Print "null" to indicate the end of the list.
    }
}
