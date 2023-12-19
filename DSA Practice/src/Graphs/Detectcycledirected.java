package Graphs;

import java.util.ArrayList;

public class Detectcycledirected {

	public static void main(String[] args) {
		int vertex = 5;
		ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>(vertex);
		for(int i=0; i<vertex; i++) {
			arraylist.add(new ArrayList<>());
		}
		
		addedge(arraylist, 0, 1);
        addedge(arraylist, 2, 1);
        addedge(arraylist, 2, 3);
        addedge(arraylist, 3, 4);
        addedge(arraylist, 4, 0);
        addedge(arraylist, 4, 2);
        
        
        
          
         
		printgraph(arraylist);
		boolean result = check(arraylist);
		System.out.println(result);

	}
	
	public static boolean check(ArrayList<ArrayList<Integer>> arraylist) {
		int vertex = 5;
		boolean[] visitedarr = new boolean[vertex];
		boolean[] pathvis = new boolean[vertex];
		for(int i=0; i<vertex; i++) {
			if(visitedarr[i] == false) {
				if(cycledfs(arraylist, visitedarr, pathvis, i)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean cycledfs(ArrayList<ArrayList<Integer>> arraylist, boolean[] visited, boolean[] pathvis, int node) {
		//DFS Approach
		//first modify the arrays
		visited[node] = true;
		pathvis[node] = true;
		
		for(int i=0; i<arraylist.get(node).size(); i++) {
			//check if visited array is 0, if not we have to make it to one, so call the function recursively
			int adjacent = arraylist.get(node).get(i);
			if(visited[adjacent] == false) {
				if(cycledfs(arraylist, visited, pathvis, adjacent)) {
					return true;
				}
			} else if(visited[adjacent] == true && pathvis[adjacent] == true) {
				return true;
			}
		}
		
		pathvis[node] = false;
		return false;
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
