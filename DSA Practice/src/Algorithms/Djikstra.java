package Algorithms;

public class Djikstra {
    public static void main(String[] args) {

        /*
           a    b   c   d   e
        a  0    10  5   0   0
        b
        c
        d
        e
         */




        int graph[][] = new int[][] {
                {0, 10, 5, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 3, 0, 9, 2},
                {0, 0, 0, 0, 4},
                {7, 0, 0, 6, 0},

        };

        dijkstra(graph, 0);
    }
    public static void dijkstra(int[][] graph, int source) {
        int count = graph.length; //number of vertices/nodes
        boolean[] visitedVertex = new boolean[count];  // visited array to mark nodes as visited or not.
        int[] distance = new int[count];

        // Initializing by marking the source node distance as 0 and all the other nodes distance as infinity.
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;  // making visited nodes as false
            distance[i] = Integer.MAX_VALUE; // making all vertices at infinite distance in the start
        }

        // Distance of self loop is zero
        //Step - 1, Mark source as zero and all the other an infinity as done above.
        distance[source] = 0;


        //do this for all the existing nodes.
        for (int i = 0; i < count; i++) {

            // Update the distance between neighbouring vertex and source vertex
            //find the minimum distance vertex to be analyzed next
            //find minimum for all the other unvisited nodes

            // finding the minimum distance node, which can be analysed(ticked) for further computation.
            int u = findMinDistance(distance, visitedVertex);

            //mark that vertex that had the minimum distance as visited
            visitedVertex[u] = true;

            // Update all the neighbouring vertex distances
            //Relax operation
            /*
            Relax = Process all the outgoing edges of the node and update only if it is giving a more efficient value.
             */
            for (int v = 0; v < count; v++) {
                if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
                    //update the distance with relaxed distance
                    distance[v] = distance[u] + graph[u][v];
                }
            }

        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
        }

    }

    // Finding the minimum distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            //not visited and smaller than already computed minDistance.
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

}
