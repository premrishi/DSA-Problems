package LinkedList;



//A node can be created only with a class
public class Linkedlist {
	//A node
	class Node{
		//Inside node, we have data and the pointer
		int data;
		//the pointer stores address of next node.
		Node next;
		
		//Constructor to get data and store in the node. its public so that its accessible
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	//after creation of node, we need head for node. so Node head
    Node head;
    
    //This is a method to insert node in beginning
    public void createNewnode(int data) {
    	//To insert a new node, we need to create a new node
    	Node newnode1 = new Node(data);
    	//Now if the existing head value is null, then the list is empty, so change the head to the newly created node
    	if(head == null) {
    		head = newnode1;
    	}
    	
	}
    
    public void insertAtbeginning(int data) {
    	//create a new node and insert value
    	Node newnode2 = new Node(data);
    	//once created, now point the new nodes next to the head of the current node
    	newnode2.next = head;
    	//now point the head to the new node
    	head = newnode2;
		
	}
    
    public void display() {
    	//start from the head with temp
    	Node temp = head;
    	//when temp is not null
    	while(temp != null) {
    		//print the temp.data
    		System.out.print(temp.data + " ");
    		//jump
    		temp = temp.next;
    	}
    }
    
    public void insertAtend(int data) {
    	//start from head with temp
    	Node temp = head;
    	//create a new node to insert
    	Node newnode4 = new Node(data);
    	//stand before the last value
    	while(temp.next != null) {
    		//store the value of next address at temp
    		temp = temp.next;
    	}
    	
    	//connect the point to new node
    	temp.next = newnode4;
    	//make the new node next to null since its last
    	newnode4.next = null;
    	
    }
    
    public void insertatpos(int pos, int data) {
    	Node temp = head;
    	Node newnode5 = new Node(data);
    	for(int i=0; i<pos-1; i++) {
    		temp = temp.next;
    	}
    	newnode5.next = temp.next;
    	temp.next = newnode5;
    	
    }
    
    public void deleteatpos(int pos) {
    	Node temp = head;
    	for(int i=0; i<pos-1; i++) {
    		temp = temp.next;
    	}
    	Node fast = temp.next.next;
    	temp.next = fast;
    	
    }
    
    public void deleteatlast() {
    	Node temp = head;
    	while(temp.next.next != null) {
    		temp = temp.next;
    	}
    	temp.next = null;
    }

}
