import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Dijkstra's algorithm is a shortest-path algorithm that finds the shortest distance from a single source node to all other nodes in a graph with non-negative edge weights. Here are the steps to understand Dijkstra's algorithm in simple terms:

1. Start by initializing the distance array with infinity for all nodes except the source node, which is set to 0.
2. Create a priority queue to store nodes with their corresponding distances. Initially, add the source node with distance 0 to the priority queue.
3. While the priority queue is not empty, do the following:
    a. Extract the node with the minimum distance from the priority queue. Let's call it the "current node."
    b. For each neighbor of the current node, calculate the total distance from the source node to the neighbor through the current node. If this distance is less than the distance recorded for the neighbor in the distance array, update the neighbor's distance.
    c. Add the updated neighbor nodes with their new distances to the priority queue.
4. Repeat step 3 until all nodes are visited or processed.
5. After the algorithm finishes, the distance array will contain the shortest distances from the source node to all other nodes in the graph.

Note: Dijkstra's algorithm assumes that all edge weights are non-negative. If there are negative edge weights, the algorithm may not produce the correct results, and other algorithms like Bellman-Ford should be used.
 */
public class _13_Dijkstras_Algorithm {
    static class Edge8 {
        int src;
        int dest;
        int wt;

        public Edge8(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void CreateGraph(ArrayList<Edge8>[] graph) {
        graph[0].add(new Edge8(0, 1, 2));
        graph[0].add(new Edge8(0, 2, 4));
        graph[1].add(new Edge8(1, 3, 7));
        graph[1].add(new Edge8(1, 2, 1));
        graph[2].add(new Edge8(2, 4, 3));
        graph[3].add(new Edge8(3, 5, 1));
        graph[4].add(new Edge8(4, 3, 2));
        graph[4].add(new Edge8(4, 5, 5));
    }

    static class pair implements Comparable<pair> {
        int node;
        int dist;

        public pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(pair p2) {
            return this.dist - p2.dist; //for Ascending Order
            //return p2.dist - this.dist; //for Descending Order
        }
    }

    public static void Dijkstras(ArrayList<Edge8>[] graph, int v, int src) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int dist[] = new int[v];
        for (int i = 0; i < v; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[v];
        pq.add(new pair(src, 0)); // Corrected the initial pair
        while (!pq.isEmpty()) {
            pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge8 e = graph[curr.node].get(i);
                    int u = e.src;
                    int V = e.dest;
                    if (dist[u] + e.wt < dist[V]) { // Corrected the typo
                        dist[V] = dist[u] + e.wt;
                        pq.add(new pair(V, dist[V])); // Add updated distance to the priority queue
                    }
                }
            }
        }
        for (int i = 0; i < v; i++) {
            System.out.println(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6; // Updated to 6 as there are 6 nodes in the graph
        ArrayList<Edge8>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge8>();
        }
        CreateGraph(graph);
        Dijkstras(graph, v, 0);
    }
}
