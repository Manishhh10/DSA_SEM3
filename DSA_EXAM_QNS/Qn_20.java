package DSA_EXAM_QNS;
import java.util.ArrayList;
import java.util.List;

public class Qn_20 {

public class CycleDetection {

    // Class to represent an edge in the graph
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Class to represent an undirected graph using an edge list
    static class Graph {
        int V; // Number of vertices
        List<Edge> edges;

        public Graph(int V) {
            this.V = V;
            edges = new ArrayList<>();
        }

        // Add an edge to the graph
        public void addEdge(int src, int dest) {
            edges.add(new Edge(src, dest));
        }
    }

    // Utility class for union-find operations
    static class UnionFind {
        int[] parent;
        int[] rank;

        // Initialize parent and rank arrays.
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // each node is initially its own parent
                rank[i] = 0;
            }
        }

        // Find with path compression
        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        // Union by rank. Returns false if x and y are already in the same set.
        public boolean union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            // x and y are already in same set
            if (xRoot == yRoot) {
                return false;
            }

            // Attach smaller rank tree under root of higher rank tree.
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
            return true;
        }
    }

    // Method to detect cycle in an undirected graph using union-find.
    public static boolean hasCycle(Graph graph) {
        UnionFind uf = new UnionFind(graph.V);

        // Iterate through all edges of the graph
        for (Edge edge : graph.edges) {
            int x = uf.find(edge.src);
            int y = uf.find(edge.dest);

            // If x and y are already in the same set, a cycle exists.
            if (x == y) {
                return true;
            }
            // Union the sets of x and y.
            uf.union(x, y);
        }
        return false;
    }

    // Example usage
    public static void main(String[] args) {
        // // Create a graph with 4 vertices (0 to 3)
        // Graph graph = new Graph(4);
        // graph.addEdge(0, 1);
        // graph.addEdge(1, 2);
        // graph.addEdge(2, 3);
        // // Uncomment the next line to introduce a cycle: 3 -> 0 (cycle exists)
        // // graph.addEdge(3, 0);

        // if (hasCycle(graph)) {
        //     System.out.println("Graph contains a cycle.");
        // } else {
        //     System.out.println("Graph doesn't contain a cycle.");
        // }
    }
}

}
