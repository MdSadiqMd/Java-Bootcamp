import java.util.ArrayList;
import java.util.PriorityQueue;

/*
This Algorithm is used to find the Smallest Distance from one Node to Another
1. We initialize the Distance Array with Value infinite
2. We Traverse in neighbors of Node and check if they had Visited[node]=false and distance is shortest
3. Then replace the value of the Distance in Array
Then we get Array of the Shortest paths from the Node to all other Nodes

Dijkstras might fail when the weight < 0
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
