package HashMap;

//Define a Node class representing a node in a linked list with additional random pointers
public class OptimCopyListwithpointer {
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

     // Create a deep copy of the linked list without using extra space and print it
     Node node1 = copyList(node);
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

 // Function to create a deep copy of a linked list with random pointers without using extra space
 public static Node copyList(Node head) {
     // 1. Zigzag insertion of new nodes in between the original linked list
     Node curr = head;
     while (curr != null) {
         Node nextNode = curr.next;
         curr.next = new Node(curr.data);
         curr.next.next = nextNode;
         curr = nextNode;
     }

     curr = head; // Reset the pointer to the head of the original list

     // 2. Setting random pointers of the clone list
     while (curr != null) {
         if (curr.next != null) {
             // Set random pointers of the clone nodes based on the original list
             curr.next.random = (curr.random != null) ? curr.random.next : null;
         }
         curr = curr.next.next;
     }

     // 3. Setting next pointers of both original and copied list
     Node orig = head; // Original list pointer
     Node copyNode = (head != null) ? head.next : null; // Copied list pointer
     Node temp = copyNode; // Save the starting point of the copied list

     while (orig != null) {
         // Adjust next pointers of both original and copied list
         orig.next = orig.next.next;
         copyNode.next = (copyNode.next != null) ? copyNode.next.next : copyNode.next;
         orig = orig.next;
         copyNode = copyNode.next;
     }

     // Return the head of the copied linked list
     return temp;
 }
}

