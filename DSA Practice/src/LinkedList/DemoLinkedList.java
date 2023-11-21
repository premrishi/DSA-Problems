package LinkedList;


public class DemoLinkedList {
	public static void main(String[] args) {
		
		Linkedlist n = new Linkedlist();
		n.createNewnode(1);
		n.insertAtbeginning(2);
		n.insertAtbeginning(3);
		n.insertAtend(10);
		n.insertatpos(3, 100);
		n.deleteatpos(3);
		n.deleteatlast();
		n.display();
	}

}
