import java.util.ArrayList;

/*
The Bellman-Ford algorithm is the shortest path algorithm that finds the shortest distance from a single source node to all other nodes in a graph. It can handle graphs with negative edge weights but may not work correctly if the graph contains negative cycles.

Steps of the Bellman-Ford algorithm:
1. Initialize the distance array with infinity for all nodes except the source node, which is set to 0.
2. Relax all the edges repeatedly for a number of iterations equal to the number of nodes minus one.
3. In each iteration, update the distance of each destination node if a shorter path is found through any neighboring edge.
4. After the iterations, check for negative cycles by relaxing all the edges one more time. If any distance is updated in this step, it indicates the presence of a negative cycle.
5. If there are no negative cycles, the distance array contains the shortest distances from the source node to all other nodes in the graph. Otherwise, the algorithm may not give correct results due to the presence of negative cycles.
6. The time complexity of the Bellman-Ford algorithm is O(V*E), where V is the number of nodes and E is the number of edges in the graph.

Bellman Ford Algorithm Fails When the """ Sum of the Cycle in Graph < 0 """
*/
public class _14_Bellman_Ford_Algorithm {
    static class Edge9 {
        int src;
        int dest;
        int wt;

        public Edge9(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void CreateGraph(ArrayList<Edge9> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge9(0, 1, 2));
        graph[0].add(new Edge9(0, 2, 4));
        graph[1].add(new Edge9(1, 2, -4));
        graph[2].add(new Edge9(2, 3, 2));
        graph[3].add(new Edge9(3, 4, 4));
        graph[4].add(new Edge9(4, 1, -1));
    }

    public static void BellmanFord(ArrayList<Edge9> graph[], int src, int v) {
        int dist[] = new int[v];
        for (int i = 0; i < v; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int k = 0; k < v - 1; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge9 e = graph[i].get(j);
                    int u = e.src;
                    int vIndex = e.dest;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[vIndex]) {
                        dist[vIndex] = dist[u] + e.wt;
                    }
                }
            }
        }
        // We run the Same Loop Again to Check if there is a Negative sum Cycle Present in the Graph
        for (int k = 0; k < v - 1; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge9 e = graph[i].get(j);
                    int u = e.src;
                    int vIndex = e.dest;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[vIndex]) {
                        System.out.println("Negative weight Cycle");
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int v = 5; // Updated to 5 as there are 5 nodes in the graph
        ArrayList<Edge9> graph[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge9>();
        }
        CreateGraph(graph);
        BellmanFord(graph, 0, v);
    }
}
