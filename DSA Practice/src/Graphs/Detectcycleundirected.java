package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detectcycleundirected {
	public static class Node {
		int val;
		int parent;
		public Node(int val, int parent) {
			this.val = val;
			this.parent = parent;
		}
	}

	public static void main(String[] args) {
		int vertex = 5;
		int[] visitedarr = new int[vertex];
		ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>(vertex);
		for(int i=0; i<vertex; i++) {
			arraylist.add(new ArrayList<>());
		}
		addedge(arraylist, 0, 1);
		addedge(arraylist, 0, 2);
		addedge(arraylist, 1, 3);
		addedge(arraylist, 2, 4);
		addedge(arraylist, 3, 4);
		
		printgraph(arraylist);
		
		System.out.println(iscycle(arraylist, 0, visitedarr));

	}
	
	public static boolean iscycle(ArrayList<ArrayList<Integer>> arraylist, int v, int visitedarr[]) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(v, -1));
		visitedarr[v] = 1;
		while(!queue.isEmpty()) {
			int u = queue.peek().val;
			int parent = queue.peek().parent;
			queue.remove();
			
			for(int i=0; i<arraylist.get(u).size(); i++) {
				if(visitedarr[arraylist.get(u).get(i)] == 0) {
					visitedarr[arraylist.get(u).get(i)] = 1;
					queue.add(new Node(arraylist.get(u).get(i), u));
				} else if(visitedarr[arraylist.get(u).get(i)] == 1 && parent!= arraylist.get(u).get(i)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void addedge(ArrayList<ArrayList<Integer>> arraylist, int source, int destination) {
		arraylist.get(source).add(destination);
		arraylist.get(destination).add(source);
	}
	
	public static void printgraph(ArrayList<ArrayList<Integer>> arraylist) {
		for(int i=0; i<arraylist.size(); i++) {
			System.out.print(i + " --> ");
			for(int j=0; j<arraylist.get(i).size(); j++) {
				System.out.print(arraylist.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}

}
