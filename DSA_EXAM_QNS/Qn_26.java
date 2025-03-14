package DSA_EXAM_QNS;

public class Qn_26 {
    // Design an algorithm to find the shortest path from all nodes to each nodes graph with negative edges
    public class FloydWarshall {

        // Define a large value to represent infinity
        private static final int INF = 99999;
    
        public static void main(String[] args) {
            // Example graph represented as an adjacency matrix
            int[][] graph = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
            };
    
            // Number of vertices in the graph
            int V = graph.length;
    
            // Compute shortest paths
            int[][] dist = floydWarshall(graph, V);
    
            // Print the shortest distances
            System.out.println("Shortest distances between all pairs of nodes:");
            printSolution(dist, V);
    
            // Check for negative cycles
            if (hasNegativeCycle(dist, V)) {
                System.out.println("The graph contains a negative cycle.");
            } else {
                System.out.println("The graph does not contain a negative cycle.");
            }
        }
    
        // Floyd-Warshall algorithm implementation
        public static int[][] floydWarshall(int[][] graph, int V) {
            // Create a distance matrix and initialize it with the input graph
            int[][] dist = new int[V][V];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = graph[i][j];
                }
            }
    
            // Update the distance matrix by considering each node as an intermediate
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        // If k is an intermediate node and provides a shorter path, update the distance
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
    
            return dist;
        }
    
        // Check for negative cycles
        public static boolean hasNegativeCycle(int[][] dist, int V) {
            for (int i = 0; i < V; i++) {
                // If the distance from a node to itself is negative, a negative cycle exists
                if (dist[i][i] < 0) {
                    return true;
                }
            }
            return false;
        }
    
        // Print the shortest distances
        public static void printSolution(int[][] dist, int V) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] == INF) {
                        System.out.print("INF\t");
                    } else {
                        System.out.print(dist[i][j] + "\t");
                    }
                }
                System.out.println();
            }
        }
    }
}
