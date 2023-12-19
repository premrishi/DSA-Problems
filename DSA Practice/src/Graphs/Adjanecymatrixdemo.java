package Graphs;

public class Adjanecymatrixdemo {
	//declare the matrix variables
	static int[][] adjmatrix;
	int vertices;
	public Adjanecymatrixdemo(int vertices) {
		this.vertices = vertices;
		adjmatrix = new int[vertices][vertices];
	}
	
	public void addedge(int i, int j) {
		adjmatrix[i][j] = 1;
		adjmatrix[j][i] = 1;
	}
	
	public static void main(String[] args) {
		Adjanecymatrixdemo matrix = new Adjanecymatrixdemo(4);
		matrix.addedge(0, 1);
		matrix.addedge(1, 2);
		matrix.addedge(2, 3);
		matrix.addedge(3, 0);
		print();
		
}
	
	public static void print() {
		for(int i=0; i<adjmatrix.length; i++){
			for(int j=0; j<adjmatrix[i].length; j++) {
				System.out.print(adjmatrix[i][j] + "");
			}
			System.out.println();
		}
	}
	

}
