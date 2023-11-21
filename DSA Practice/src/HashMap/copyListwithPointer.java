package HashMap;

import java.util.HashMap;

//Define a Node class representing a node in a linked list with additional random pointers
public class copyListwithPointer {
 public static class Node {
     int data; // Data of the node
     Node next; // Pointer to the next node in the list
     Node random; // Pointer to a random node in the list

     // Constructor to initialize the node with data
     Node(int data) {
         this.data = data;
         this.next = null;
         this.random = null;
     }
 }

 public static void main(String[] args) {
     // Create a linked list with nodes and set random pointers
     Node node = new Node(1);
     node.next = new Node(2);
     node.next.next = new Node(3);
     node.next.next.next = new Node(4);
     node.next.next.next.next = new Node(5);

     // Set random pointers for some nodes
     node.random = node.next.next;
     node.next.random = node;
     node.next.next.random = node.next.next;
     node.next.next.next.random = node.next;
     node.next.next.next.next.random = node.next.next.next;

     // Print the original linked list
     printList(node);

     System.out.println();

     // Create a deep copy of the linked list and print it
     Node node1 = copyRandomList(node);
     printList(node1);
 }

 // Print the linked list
 public static void printList(Node node) {
     Node temp = node;

     while (temp != null) {
         System.out.print(temp.data + " -> ");
         temp = temp.next;
     }
     System.out.print("null");
 }

 // Function to create a deep copy of a linked list with random pointers
 public static Node copyRandomList(Node head) {
     // Check if the original linked list is empty
     if (head == null) {
         return null;
     }

     Node temp = head; // Temporary pointer for traversing the original list
     HashMap<Node, Node> hashMap = new HashMap<>(); // HashMap to map original nodes to their clones

     // First pass: Create clones of each node and map original nodes to their clones
     while (temp != null) {
         // Map each original node to its corresponding clone node with the same data
         hashMap.put(temp, new Node(temp.data));
         temp = temp.next;
     }

     temp = head; // Reset the pointer to the head of the original list

     // Second pass: Connect next and random pointers of the clone nodes using the mapping
     while (temp != null) {
         // Connect the next and random pointers of the clone nodes
         hashMap.get(temp).next = hashMap.get(temp.next);
         hashMap.get(temp).random = hashMap.get(temp.random);
         temp = temp.next;
     }

     // Return the head of the cloned linked list
     return hashMap.get(head);
 }
}
