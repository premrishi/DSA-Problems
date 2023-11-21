package Trees;

import java.util.ArrayList;

public class nodeToRoot {
	public static ArrayList<Integer> arrayList = new ArrayList<>();
	public static ArrayList<ArrayList<Integer>> multilist = new ArrayList<>();
	
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(7);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);	
		node.right.right.left = new Node(8);
		int t = 7;
		
		//nodetoroot(node, t);
		//System.out.println(arrayList);
		Duplicatesnodetoroot(node, t, arrayList);
		System.out.println(multilist);
	}
	
	public static boolean nodetoroot(Node node, int target) {
		if(node == null) {
			return false;
		}
		
		if(node.data ==  target) {
			arrayList.add(node.data);
			return true;
		}
		
		boolean L = nodetoroot(node.left, target);
		boolean R = nodetoroot(node.right, target);
		boolean ans = L || R;
		
		if(ans == true) {
			arrayList.add(node.data);
		}
		return ans;
	}
	
	//===================================================================================================
	
	public static boolean Duplicatesnodetoroot(Node node, int target, ArrayList<Integer> arrayList) {
		if(node == null) {
			return false;
		}
		
		if(node.data ==  target) {
			arrayList.add(node.data);
			multilist.add(new ArrayList<>(arrayList));
			return true;
		}
		
		arrayList.add(node.data);
		boolean L = Duplicatesnodetoroot(node.left, target, new ArrayList<>(arrayList));
		boolean R = Duplicatesnodetoroot(node.right, target, new ArrayList<>(arrayList));
		boolean ans = L || R;
		
		return ans;
	}

}
