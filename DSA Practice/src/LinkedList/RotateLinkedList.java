package LinkedList;

public class RotateLinkedList {
	public static class Node {
        int data;
        Node next;

        Node(int data) {
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
        System.out.println("Original link list");
        printList(node);
        System.out.println();

        node = rotateList(node, 2);
        System.out.println("Rotated linked list");
        printList(node);
    }

    public static Node rotateList(Node node, int n) {
        int length = 1;
        Node temp = node;

        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        //making the list as circular linked list
        temp.next = node;

        //go till break node

        n = (length - n) % length;

        Node curr = node;
        for (int i=0; i<n-1; i++) {
            curr = curr.next;
        }

        node = curr.next; // make it as new head
        curr.next = null; // point the next of break node as null

        return node;
    }

    public static void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

}
