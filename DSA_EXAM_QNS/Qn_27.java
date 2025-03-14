package DSA_EXAM_QNS;

import java.util.*;
public class Qn_27 {


public class Qn_10 {

    static class Edge implements Comparable<Edge> {
        int u, v, w; // u and v: endpoints; w: weight

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge other) {
            return this.w - other.w;
        }
    }

    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public static int largestKNotConnected(int V, List<Edge> edgesList) {
        Collections.sort(edgesList);

        UnionFind uf = new UnionFind(V);
        int maxEdgeWeight = Integer.MIN_VALUE;
        int edgeCount = 0;

        for (Edge edge : edgesList) {
            if (uf.union(edge.u, edge.v)) {
                maxEdgeWeight = Math.max(maxEdgeWeight, edge.w);
                edgeCount++;
                if (edgeCount == V - 1) break; // MST is complete.
            }
        }
        return maxEdgeWeight;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 5));
        edges.add(new Edge(1, 2, 6));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        edges.add(new Edge(3, 4, 8));
        edges.add(new Edge(2, 4, 12));

        int k = largestKNotConnected(V, edges);
        System.out.println("The largest value of k such that removing every edge with weight >= k disconnects the graph is: " + k);
    }
}

}
