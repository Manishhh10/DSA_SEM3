import java.util.ArrayList;
import java.util.List;

public class AdjList {
    linkedlist adjlist[];
    int vertices;

    AdjList(int vertices){
        this.vertices = vertices;
        adjlist = new linkedlist[vertices];
        for (int i = 0; i < vertices; i++) {
            adjlist[i] = new linkedlist();
        }
    }

    void addEdges(int u, int v){
        adjlist[u].addNode(v);
        adjlist[v].addNode(u);
    }

    void printGraph(){
        for (int i = 0; i < vertices; i++) {
            // row
            System.out.print(i + " is connceted to ");
            linkedlist.Node current = adjlist[i].head;
            while (current!=null) {
                System.out.print(current.data + ", ");
                current=current.next;
            }
            System.out.println();
        }
    }

    // make method getAdjNodes
    List<Integer> getAdjNodes(int i){
        List<Integer> adjnodes = new ArrayList<>();
        linkedlist.Node current = adjlist[i].head;
            while (current!=null) {
                adjnodes.add(current.data);
                current = current.next;
            }
            return adjnodes;
        }


    // DFS
    // Depth First Search
    void depthfirstsearch(int source){
        boolean visited[] = new boolean[vertices];
        dfs(source,visited);
    }

    void dfs(int rootnode, boolean[] visited){
        System.out.println(rootnode);
        visited[rootnode]=true;
        //getAdjnodes and traverse through list
        linkedlist.Node current = adjlist[rootnode].head;
        while (current!=null) {
            if (!visited[current.data]) {
                dfs(current.data, visited);
            }
            current=current.next;
        }
    }
        

    public static void main(String[] args) {
        AdjList adj = new AdjList(5);
        adj.addEdges(0, 1);
        adj.addEdges(0, 2);
        adj.addEdges(1, 3);
        adj.addEdges(1, 4);
        adj.addEdges(2, 3);
        adj.addEdges(3, 4);
        adj.printGraph();
    }
}


