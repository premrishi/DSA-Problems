package Graphs;

import java.util.ArrayList;

public class AdjacencyListDemo {

	public static void main(String[] args) {
		int vertex = 4;
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>(vertex);
		
		for(int i=0; i<vertex; i++) {
			arrayList.add(new ArrayList<>());
		}
			addedge(arrayList,0, 1);
			addedge(arrayList, 1, 2);
			addedge(arrayList, 2, 3);
			addedge(arrayList, 3, 0);
			
			print(arrayList);
	}
	
	public static void addedge(ArrayList<ArrayList<Integer>> arrayList, int source, int destination) {
		arrayList.get(source).add(destination);
		arrayList.get(destination).add(source);
	}
	
	public static void print(ArrayList<ArrayList<Integer>> arrayList) {
		for(int i=0; i<arrayList.size(); i++) {
			for(int j=0; j<arrayList.get(i).size(); j++) {
				System.out.print(arrayList.get(i).get(j));
			}
			System.out.println();
		}
		
	}

}
