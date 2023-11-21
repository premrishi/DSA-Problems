package LinkedList;

public class ReOrderList {
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
        System.out.println("Original list");
        printList(node);
        System.out.println();

        node = reorderList(node);
        System.out.println("Reordered list");
        printList(node);
    }

    /*
    Step - 1. Find the middle
    Step - 2. Reverse the second half
    Step - 3. Start merging
     */
    public static Node reorderList(Node node) {

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        Node prev = null, slow = node, fast = node, l1 = node;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        // 1->2->null

        // step 2. reverse the 2nd half
        Node l2 = reverse(slow);

        // step 3. merge the two halves
        merge(l1, l2);

        return node;
    }

    public static Node reverse(Node head) {
        Node prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void merge(Node l1, Node l2) {
        while (l1 != null) {
            Node n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
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
