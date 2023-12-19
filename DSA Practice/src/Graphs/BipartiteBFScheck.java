package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFScheck {

	public static void main(String[] args) {
		/*int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };*/
		
		int[][] graph = {
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };
		
		ArrayList<ArrayList<Integer>> ans = matrixtolist(graph);
		//printlist(ans);
		boolean result = checkbipartite(ans, 0);
		System.out.print(result);
		

	}
	
	
	
	//bfs
	public static boolean checkbipartite(ArrayList<ArrayList<Integer>> list, int v) {
		//create array
		int[] visited = new int[list.size()];
		Arrays.fill(visited, -1);
		//mainatin queue
		Queue<Integer> queue = new LinkedList<>();
		//insert the first to queue and color visited
		queue.add(v);
		visited[v] = 0;
		while(!queue.isEmpty()) {
			int current = queue.remove();
			for(int i=0; i<list.get(current).size(); i++) {
				int u = list.get(current).get(i);
					if(visited[u] == -1) {
						visited[u] = 1 - visited[current];
						queue.add(u);
					} else if(visited[u] == visited[current]) {
						return false;
					}
				}
		}
		return true;
	}
	
	public static ArrayList<ArrayList<Integer>> matrixtolist(int[][] graph) {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<graph.length; i++) {
			ArrayList<Integer> neighbour = new ArrayList<>();
			for(int j=0; j<graph[i].length; j++) {
					neighbour.add(graph[i][j]);
			}
			list.add(neighbour);
		}
		return list;
	}
	
	public static void printlist(ArrayList<ArrayList<Integer>> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.print(i+ " ");
			for(int j=0; j<list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j));
			}
			System.out.println();
		}
	}

}
