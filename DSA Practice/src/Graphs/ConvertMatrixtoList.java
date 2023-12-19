package Graphs;

import java.util.ArrayList;

public class ConvertMatrixtoList {
	int vertices;
	static int[][] adjmatrix;
	public ConvertMatrixtoList(int vertices) {
		this.vertices = vertices;
		adjmatrix = new int[vertices][vertices];
	}
	
	public void edge(int i, int j) {
		adjmatrix[i][j] = 1;
		adjmatrix[j][i] = 1;
		
	}
	
	public static void main(String[] args) {
		ConvertMatrixtoList matrix = new ConvertMatrixtoList(4);
		matrix.edge(0, 1);
		matrix.edge(1, 2);
		matrix.edge(2, 3);
		matrix.edge(3, 0);
		ArrayList<ArrayList<Integer>> converted = matrixtolist(adjmatrix);
		print(converted);
	}
	
	public static void print(ArrayList<ArrayList<Integer>> arrayList) {
		for(int i=0; i<arrayList.size(); i++) {
			for(int j=0; j<arrayList.get(i).size(); j++) {
				System.out.print(arrayList.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> matrixtolist(int[][] matrix) {
		int vertex = matrix[0].length;
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>(vertex);
		for(int i=0; i<vertex; i++) {
			arrayList.add(new ArrayList<>());
		}
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j] != 0 ) {
					arrayList.get(i).add(j);
				}
			}
		}
		
		return arrayList;
	}
	
	

}
