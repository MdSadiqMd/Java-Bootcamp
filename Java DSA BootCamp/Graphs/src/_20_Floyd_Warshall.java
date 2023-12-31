import java.util.ArrayList;
// This Floyd Warshall Algorithm computes the distance from one node to all other nodes and so on from other Node to all other Nodes
// This is usually is used to find the Minimum distance from one Node to another Node
// Here we use Adjacency Matrix Method other than Adjacency List
// *** The Time complexity is O(n^3) which is *not Efficient, but it works for negative weights
// *** IF positive weights use Bellman Ford if negative weights use this algorithm

public class _20_Floyd_Warshall {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void floydWarshall(ArrayList<Edge>[] graph){
        int V=graph.length;
        int[][] dist=new int[V][V];

        // Initialise Matrix
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(i==j){
                    dist[i][j]=0;
                } else {
                    dist[i][j]= Integer.MAX_VALUE;
                }
            }
        }

        // Set Initial distances from graph
        for (ArrayList<Edge> edges : graph) {
            for (Edge edge : edges) {
                dist[edge.src][edge.dest] = edge.wt;
            }
        }

        // Floyd Warshall Algorithm
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                for(int k=0;k<V;k++){
                    if(dist[i][k]!= Integer.MAX_VALUE && dist[k][j]!= Integer.MAX_VALUE && dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }

        // Printing Result
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(dist[i][j]+" --> ");
            }
            System.out.println();
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge>[] graph =new ArrayList[v];
        CreateGraph(graph);
        floydWarshall(graph);
    }
}
