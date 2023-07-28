import java.util.ArrayList;

class Triple {
    int src;
    int dest;
    int weight;

    Triple(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class _11_Bellman_Ford_Algorithm_Negative_Weight_Cycle {
    public static boolean hasNegativeWeightCycle(int v, ArrayList<Triple> edges, int source) {
        int[] dist = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;

        // Relax edges repeatedly (V - 1) times
        for (int i = 0; i < v - 1; i++) {
            for (Triple edge : edges) {
                int u = edge.src;
                int v1 = edge.dest;
                int weight = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v1]) {
                    dist[v1] = dist[u] + weight;
                }
            }
        }

        // Check for negative weight cycles
        for (Triple edge : edges) {
            int u = edge.src;
            int v1 = edge.dest;
            int weight = edge.weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Example usage of Bellman-Ford algorithm
        int v = 5; // Number of vertices

        // Example graph with edges and weights
        ArrayList<Triple> edges = new ArrayList<>();
        edges.add(new Triple(0, 1, -1));
        edges.add(new Triple(0, 2, 4));
        edges.add(new Triple(1, 2, 3));
        edges.add(new Triple(1, 3, 2));
        edges.add(new Triple(1, 4, 2));
        edges.add(new Triple(3, 2, 5));
        edges.add(new Triple(3, 1, 1));
        edges.add(new Triple(4, 3, -3));

        int source = 0; // Source vertex for the Bellman-Ford algorithm

        boolean hasNegativeCycle = hasNegativeWeightCycle(v, edges, source);

        if (hasNegativeCycle) {
            System.out.println("The graph contains a negative weight cycle.");
        } else {
            System.out.println("The graph does not contain any negative weight cycle.");
        }
    }
}
