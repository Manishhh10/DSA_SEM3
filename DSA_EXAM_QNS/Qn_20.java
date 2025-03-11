package DSA_EXAM_QNS;
public class Qn_20 {
    // Implement disjoint find and union operation to detect cycle in undirected graph
    public class DisjointSet {
        int size[];
        int parent[];   
        int vertices;
    
        DisjointSet(int vertices) {
            this.vertices = vertices;
            size = new int[vertices];
            parent = new int[vertices];
    
            for (int i = 0; i < vertices; i++) {
                parent[i] = i; // Each node is its own parent initially
                size[i] = 1; // Initialize size to 1
            }
        }
    
        void findCycle(int u, int v) {
            int uRoot = find(u);
            int vRoot = find(v);
    
            if (uRoot == vRoot) {
                System.out.println("Cycle detected!");
            } else {
                union(uRoot, vRoot); // Merge sets
            }
        }
    
        void union(int uRoot, int vRoot) {
            if (size[uRoot] > size[vRoot]) {
                parent[vRoot] = uRoot;
            } else if (size[uRoot] < size[vRoot]) {
                parent[uRoot] = vRoot;
            } else {
                parent[vRoot] = uRoot;
                size[uRoot]++; // Increase rank only when both sets are of equal size
            }
        }
    
        int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // Path compression
            }
            return parent[u];
        }
    
        public static void main(String[] args) {
            DisjointSet d = new DisjointSet(4);
            d.findCycle(0, 1);
            d.findCycle(1, 2);
            d.findCycle(2, 3);
            d.findCycle(3, 0); // This should detect a cycle
        }
    }
    

}