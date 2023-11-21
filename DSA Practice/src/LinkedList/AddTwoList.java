package LinkedList;

public class AddTwoList {
	public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(3);

        Node node2 = new Node(5);
        node2.next = new Node(6);
        node2.next.next = new Node(4);

        Node ansNode = addTwoList(node1, node2);
        printList(ansNode);
    }

    public static Node addTwoList(Node node1, Node node2) {
        Node ansNode = new Node(0);
        Node curr = ansNode;
        Node p = node1;
        Node q = node2;

        int carry = 0;

        while (p != null || q != null) {
            int x = p!=null ? p.data : 0;
            int y = q!=null ? q.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            curr.next = new Node(sum%10);
            curr = curr.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            curr.next = new Node(carry);
        }

        return ansNode.next;
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
