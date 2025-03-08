package DSA_EXAM_QNS;
import java.util.*;

public class Qn_18 {
    
public class TopologicalSort {

    /**
     * Performs topological sort on a directed graph represented as an adjacency list.
     *
     * @param graph    A map representing the graph where keys are node IDs and values are lists of adjacent nodes.
     * @param numNodes Total number of nodes in the graph.
     * @return A list containing the nodes in topologically sorted order, or null if the graph has a cycle.
     */
    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int numNodes) {
        // Compute the in-degree for each node.
        int[] inDegree = new int[numNodes];
        for (int node : graph.keySet()) {
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]++;
            }
        }
        
        // Initialize a queue with all nodes having zero in-degree.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numNodes; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Process nodes with zero in-degree.
        List<Integer> sortedOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sortedOrder.add(node);
            
            // If the node has neighbors, reduce their in-degree.
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        // Check if a cycle exists: the sorted order must contain all nodes.
        if (sortedOrder.size() != numNodes) {
            System.out.println("Cycle detected. Topological ordering not possible.");
            return null;
        }
        
        return sortedOrder;
    }
    
    public static void main(String[] args) {
        // // Example: Constructing a sample graph.
        // // Graph:
        // // 0 -> 1, 0 -> 2
        // // 1 -> 3
        // // 2 -> 3
        // Map<Integer, List<Integer>> graph = new HashMap<>();
        // graph.put(0, Arrays.asList(1, 2));
        // graph.put(1, Arrays.asList(3));
        // graph.put(2, Arrays.asList(3));
        // // Node 3 has no outgoing edges so it need not be in the map.

        // int numNodes = 4; // Total nodes labeled 0 through 3
        // List<Integer> order = topologicalSort(graph, numNodes);
        // if (order != null) {
        //     System.out.println("Topological Order: " + order);
        // }
    }
}

}
