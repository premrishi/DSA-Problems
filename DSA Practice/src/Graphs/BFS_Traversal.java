package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Traversal {

	public static void main(String[] args) {
		int vertex = 8;
		ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>(vertex);
		for(int i=0; i<vertex; i++) {
			arraylist.add(new ArrayList<>());
		}
		addedge(arraylist, 0, 1);
		addedge(arraylist, 0, 2);
		addedge(arraylist, 1, 3);
		addedge(arraylist, 1, 4);
		addedge(arraylist, 2, 5);
		addedge(arraylist, 2, 6);
		addedge(arraylist, 3, 7);
		addedge(arraylist, 4, 7);
		addedge(arraylist, 5, 7);
		addedge(arraylist, 6, 7);
		
		printgraph(arraylist);
		
		BFS(arraylist, 0);
		
	}
	
	public static void BFS(ArrayList<ArrayList<Integer>> arraylist, int v) {
		//maintain a visited array
		int[] visitedarr = new int[arraylist.size()];
		for(int i=0; i<visitedarr.length; i++) {
			visitedarr[i] = 0;
		}
		//maintain a queue
		Queue<Integer> queue = new LinkedList<>();
		//add the first element to the queue and output it
		int u = v;
		visitedarr[u] = 1;
		queue.add(u);
		System.out.print(u + "");
		
		while(!queue.isEmpty()) {
			int currentelement = queue.remove();
			for(int i=0; i<arraylist.get(currentelement).size(); i++) {
				if(visitedarr[arraylist.get(currentelement).get(i)] == 0) {
					visitedarr[arraylist.get(currentelement).get(i)] = 1;
					queue.add(arraylist.get(currentelement).get(i));
					System.out.print(arraylist.get(currentelement).get(i) + "");
				}
			}
		}
	}
	
	public static void addedge(ArrayList<ArrayList<Integer>> arraylist, int source, int destination) {
		arraylist.get(source).add(destination);
		arraylist.get(destination).add(source);
	}
	
	public static void printgraph(ArrayList<ArrayList<Integer>> arraylist) {
		for(int i=0; i<arraylist.size(); i++) {
			System.out.print(i + " -> ");
			for(int j=0; j<arraylist.get(i).size(); j++) {
				System.out.print(arraylist.get(i).get(j));
			}
			System.out.println();
		}
		
	}

}
