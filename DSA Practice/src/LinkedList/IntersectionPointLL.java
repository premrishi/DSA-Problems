package LinkedList;

public class IntersectionPointLL {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node firstList = new Node(1);
        firstList.next = new Node(2);
        firstList.next.next = new Node(3);
        firstList.next.next.next = new Node(4);
        firstList.next.next.next.next = new Node(5);
        printList(firstList);

        int lengthDifference = 0;

        System.out.println();

        Node secondList = new Node(8);
        secondList.next = new Node(6);
        secondList.next.next = firstList.next.next.next;

        printList(secondList);

        int node1Length = getLength(firstList);
        int node2Length = getLength(secondList);

        System.out.println();
        System.out.println("First firstList length : " +node1Length);
        System.out.println("Second firstList length : " +node2Length);

        Node aheadNode = firstList;
        Node behindNode = firstList;

        if (node1Length >= node2Length) {
            lengthDifference = node1Length - node2Length;
            aheadNode = firstList;
            behindNode = secondList;
        } else {
            lengthDifference = node2Length - node1Length;
            aheadNode = secondList;
            behindNode = firstList;
        }

        /*
        Give a headstart to the bigger list
         */
        while (lengthDifference > 0) {
            aheadNode = aheadNode.next;
            lengthDifference--;
        }

        int flag = 0;

        // Traverse till the meeting point
        while (aheadNode != null) {
            if (aheadNode == behindNode) {
                //System.out.println("Intersection firstList : " +aheadNode.data);
                flag=1;
                break;
            }

            aheadNode = aheadNode.next;
            behindNode = behindNode.next;
        }
        if (flag == 1) {
            System.out.println("Intersection point :"  +aheadNode.data);
        } else {
            System.out.println("No intersection point");
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

    public static int getLength(Node node) {
        int length = 0;
        Node temp = node;

        while (temp != null) {
            temp = temp.next;
            length++;
        }

        return length;
    }
}
