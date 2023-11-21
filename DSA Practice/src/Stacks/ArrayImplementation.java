package Stacks;

import java.util.Arrays;

public class ArrayImplementation {
	public static int top = -1;
	public static final int max = 6;
	public static int[] stack = new int[max];

	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		push(6);
		//push(7);
		//pop();
		int t1 = pop();
		System.out.println(t1);
		System.out.println(Arrays.toString(stack));
		

	}
	
	public static void push(int item) {
		if(top == max-1) {
			System.out.println("stack overflow");
			return;
		}
		top++;
		stack[top] = item;	
	}
	
	public static int pop() {
		if(top == -1) {
			System.out.println("Underflow");
			return -1;
		}
		int topelement = stack[top];
		top--;
		return topelement;
		
	}

}
