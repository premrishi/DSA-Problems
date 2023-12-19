package Graphs;

import java.util.ArrayList;

public class NumberofProvince {

	public static void main(String[] args) {
		int[][] isConnected = {
              {1, 1, 0},
              {1, 1, 0},
              {0, 0, 1}
      };
		ArrayList<ArrayList<Integer>> list = matrixtolist(isConnected);
		printgraph(list);
		System.out.println(dft(list));
		

	}
	
	public static int dft(ArrayList<ArrayList<Integer>> list) {
		int[] visited = new int[list.size()];
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				count+=1;
				dfs(list, i, visited);
			}
		}
		return count;
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> list, int node, int[] visited) {
		//make visite to 1
		visited[node] = 1;
		for(int i=0; i<list.get(node).size(); i++) {
			int u = list.get(node).get(i);
			if(visited[u] == 0) {
				dfs(list, u, visited);
			}
		}
	}
	
	//function to convert matrix to araylist
	public static ArrayList<ArrayList<Integer>> matrixtolist(int[][] array) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		int vertex = array.length;
		for(int i=0; i<vertex; i++) {
			arrayList.add(new ArrayList<>());
		}
		for(int i=0; i<vertex; i++) {
			for(int j=0; j<vertex; j++) {
				if(array[i][j] == 1) {
					arrayList.get(i).add(j);
				}
			}
		}
		return arrayList;
		
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
