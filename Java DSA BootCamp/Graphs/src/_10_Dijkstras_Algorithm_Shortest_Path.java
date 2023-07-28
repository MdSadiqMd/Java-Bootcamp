import java.util.ArrayList;
import java.util.PriorityQueue;

class pair1 implements Comparable<pair1> {
    int v;
    int dist;

    pair1(int v, int dist) {
        this.v = v;
        this.dist = dist;
    }

    public int compareTo(pair1 that) {
        return this.dist - that.dist;
    }
}

public class _10_Dijkstras_Algorithm_Shortest_Path {
    public static int[] dijkstra(int v, ArrayList<ArrayList<pair1>> adj, int source) {
        int[] dist = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[source] = 0;
        PriorityQueue<pair1> pq = new PriorityQueue<>();
        pq.add(new pair1(source, 0));

        while (!pq.isEmpty()) {
            pair1 cur = pq.remove();
            int u = cur.v;
            int curDist = cur.dist;

            if (curDist > dist[u]) {
                continue; // Skip outdated entries in the priority queue
            }

            for (pair1 neighbor : adj.get(u)) {
                v = neighbor.v;
                int weight = neighbor.dist;

                if (curDist + weight < dist[v]) {
                    dist[v] = curDist + weight;
                    pq.add(new pair1(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        // Example usage of Dijkstra's algorithm
        int v = 6; // Number of vertices
        ArrayList<ArrayList<pair1>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add weighted edges to the graph (adjacency list representation)
        addEdge(adj, 0, 1, 5);
        addEdge(adj, 0, 2, 3);
        addEdge(adj, 1, 3, 6);
        addEdge(adj, 1, 4, 2);
        addEdge(adj, 2, 3, 1);
        addEdge(adj, 2, 4, 4);
        addEdge(adj, 3, 5, 8);
        addEdge(adj, 4, 5, 5);

        int source = 0; // Source vertex for Dijkstra's algorithm

        int[] shortestDistances = dijkstra(v, adj, source);

        // Print the shortest distances from the source vertex to all other vertices
        System.out.println("Shortest Distances from Vertex " + source + ":");
        for (int i = 0; i < v; i++) {
            System.out.println("Vertex " + i + ": " + shortestDistances[i]);
        }
    }

    // Helper method to add a weighted edge to the adjacency list
    private static void addEdge(ArrayList<ArrayList<pair1>> adj, int u, int v, int weight) {
        adj.get(u).add(new pair1(v, weight));
        adj.get(v).add(new pair1(u, weight)); // For undirected graphs
    }
}
