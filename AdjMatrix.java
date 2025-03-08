import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class AdjMatrix {
    // mst
    public static class Edge{
        int u;
        int v;
        int w;
        Edge(int u,int v,int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o){

        }
    }
    // mst end
    int[][] matrix;
    int vertices;

    AdjMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }
    //mst start
    //mst end
    int[][] matrix;
    int vertices;

    Edge [] edge; //mst
    int edgeindex=-1;//mst

    AdjMatrix(int vertices){
        this.vertices=vertices;
        matrix=new Edge[vertices][vertices];
        edges =new Edge[vertices*(vertices-1)/2];
    }

    void addEdges(int u, int v, int w) {
        // u - source
        // v -destination
        matrix[u][v] = 1;
        matrix[v][u] = 1;
        edges[++edgeindex] = new Edge(u,v,w);//mst adding edge to list
        // new Edge(u, v, w){
        //     matrix[u][v]=w;
        //     matrix[v][u]=w;
            
        // }
    }
    // mst start
    void krushkalAlgorithm(){
        int parent[]=new int[vertices];
        int size[]=new int[vertices];
        int mst[][]=new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i]=-1;
        }
        Array.sort(edges);
        int edgeTaken=0;
        int edgeCounter=-1;
        while (edgeTaken < vertices) {
            Edge e=edges[++edgeCounter];
            int uabsroot = find(e.u,parent);
            int vabsroot = find(e.v.parent);
            if (uabsroot==vabsroot) {
                // cycle detected
                continue;
            }
            mst[e.u][e.v]=e.w;
            mst[e.v][e.u]=e.w;
            union(uabsroot, vabsroot, parent, size);
            edgeTaken++;
        }
    }

    void union(int uabsroot, int vabsroot, int parent,int size){
        if (size[uabsroot]>size[vabsroot]) {
            parent[vabsroot]=uabsroot;
        }
        else if(size[uabsroot]<size[vabsroot]){
            parent[uabsroot]=vabsroot;
        }
        else{
            parent[uabsroot]=vabsroot;
            size[vabsroot]++;
        }
    }

    int find(int u,int parent[]){
        if (parent[u]==-1) {
            return u;
        }
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            // row
            System.out.print(i + " is connected to ");
            for (int j = 0; j < vertices; j++) {
                // column
                if (matrix[i][j] != 0) {
                    // i,j are connected
                    System.out.print(j + ", ");
                }
            }
            System.out.println();
        }
    }

    List<Integer> getAdjNodes(int i) {
        List<Integer> adjnodes = new ArrayList<>();
        for (int j = 0; j < vertices; j++) {
            if (matrix[i][j] != 0) {
                adjnodes.add(j);
            }
        }
        return adjnodes;
    }

    // BFS - Breadth first search
    void BFS(int source) {
        Queue q = new Queue(vertices);
        boolean visited[] = new boolean[vertices];
        q.enqueue(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int x = q.dequeue();
            System.out.println(x);

            // call getAdjNodes function and iterate through list
            for (int j = 0; j < vertices; j++) {
                if (matrix[x][j] != 0) {
                    if (!visited[j]) {
                        q.enqueue(j);
                        visited[j] = true;
                    }
                }
            }
        }
    }

    // Dijkstra Algorithm
    int dijakstra(int source, int destination) {
        int dist[] = new int[vertices];
        int prevpath[] = new int[vertices];
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;
        }
        dist[source] = 0;

        for (int i = 0; i < vertices; i++) {
            // find min vertex
            int minvertex = findMinvertex(dist, visited);
            if (minvertex == -1) break; // If no vertex is found, break
            visited[minvertex] = true;
            for (int j = 0; j < vertices; j++) {
                if (matrix[minvertex][j] != 0) {
                    if (!visited[j] && dist[minvertex] + matrix[minvertex][j] < dist[j]) {
                        dist[j] = dist[minvertex] + matrix[minvertex][j];
                        prevpath[j] = minvertex;
                    }
                }
            }
        }
        // print path
        int x = destination;
        Stack<Integer> stk = new Stack<>();
        stk.push(x);
        while (prevpath[x] != -1) {
            x = prevpath[x];
            stk.push(x);
        }
        System.out.print("Path: ");
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
        System.out.println();
        return dist[destination];
    }

    int findMinvertex(int[] dist, boolean[] visited) {
        int min = -1;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && (min == -1 || dist[i] < dist[min])) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        AdjMatrix adj = new AdjMatrix(6);
        adj.addEdges(0, 1);
        adj.addEdges(0, 2);
        adj.addEdges(1, 2);
        adj.addEdges(1, 3);
        adj.addEdges(2, 3);
        adj.addEdges(2, 4);
        adj.addEdges(3, 5);

        adj.printGraph();

        System.out.println("Shortest path using Dijkstra's Algorithm:");
        int distance = adj.dijakstra(0, 5);
        System.out.println("Shortest distance: " + distance);
    }
}


// write an algorithm to detect cycle in graph using bfs and dfs.
// critically analyze the time complexity of prince and krushkal alogotihm.