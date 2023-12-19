package Graphs;

import java.util.ArrayList;

public class DFS_Traversal {
	static int vertex = 8;
	static int[] visitedarr = new int[vertex];
	public static void main(String[] args) {
		
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
		System.out.println();
		DFS(arraylist, 0);

	}
	
	public static void DFS(ArrayList<ArrayList<Integer>> arraylist, int v) {
		visitedarr[v] = 1;
		System.out.print(v);
		for(int i=0; i<arraylist.get(v).size(); i++) {
			int w = arraylist.get(v).get(i);
			if(visitedarr[w] == 0) {
				DFS(arraylist, w);
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
