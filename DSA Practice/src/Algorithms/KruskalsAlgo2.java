package Algorithms;

import java.util.*;



public class KruskalsAlgo2 {
    private int vertices;
    private List<Edge> edges;

    public KruskalsAlgo2(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }

    public int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);

        //adding the ultimate parent into the parent array
        parent[xset] = yset;
    }

    public void kruskalMST() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        int[] parent = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        List<Edge> mst = new ArrayList<>();

        while (mst.size() < vertices - 1) {
            Edge edge = pq.remove();


            // to find whether both the nodes hace same ultimate parents or not.
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if (x != y) {
                mst.add(edge);
                union(parent, x, y);
            }
        }

        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight);
        }
    }

    public static void main(String[] args) {
        KruskalsAlgorithm graph = new KruskalsAlgorithm(4);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        graph.kruskalMST();
    }
}
