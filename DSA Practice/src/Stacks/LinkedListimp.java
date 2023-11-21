package Stacks;

class StackUsingLinkedlist {

    private class Node {

        int data;
        Node link; 
    }

    Node top;

    StackUsingLinkedlist()
    {
        this.top = null;
    }

    // Using this function we will be pushing elements into the stack
    public void push(int x) {
        Node temp = new Node();
        temp.data = x;
        temp.link = top;
        top = temp;
    }


    // Using this function we will be checking whether the stack is empty or not
    public boolean isEmpty()
    {
        return top == null;
    }

    // using this function we will return the top element of the stack
    public int peek()
    {

        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    // Using this function we will pop the top element of the stack
    public void pop() {
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }

        // Store the data of the top node to be popped
        int poppedValue = top.data;

        // Move top to the next node
        top = top.link;

        // Optional: Print the popped value
        System.out.println("Popped element: " + poppedValue);
    }


    // this function will be used to display the items of the stack
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.printf("%d->", temp.data);
                temp = temp.link;
            }
        }
        System.out.println(); // Add a newline for better formatting
    }

}

class LinkedListimp {
    public static void main(String[] args)
    {

        StackUsingLinkedlist stk = new StackUsingLinkedlist();

        stk.push(4);
        stk.push(3);
        stk.push(2);
        stk.push(1);

        stk.display();

        System.out.printf("\nTop element is %d\n", stk.peek());
        System.out.println("Stack after popping 2 times");
        stk.pop();
        stk.pop();

        stk.display();

        System.out.printf("\nTop element is %d\n", stk.peek());
    }
}