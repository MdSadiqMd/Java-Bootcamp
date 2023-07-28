import java.util.ArrayList;
import java.util.PriorityQueue;

class pair implements Comparable<pair> {
    int wt;
    int v;

    pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }

    public int compareTo(pair that) {
        return this.wt - that.wt;
    }
}

public class _9_Primes_Algorithm_Minimum_Spanning_Tree {
    public static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[] vis = new boolean[v];
        PriorityQueue<pair> q = new PriorityQueue<>();
        q.add(new pair(0, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            pair cur = q.remove();
            int u = cur.v;
            if (vis[u]) {
                continue;
            } else {
                ans += cur.wt;
                vis[u] = true;
                ArrayList<ArrayList<Integer>> neighbour = adj.get(u);
                for (ArrayList<Integer> list : neighbour) {
                    int vertex = list.get(0);
                    int wt = list.get(1);
                    if (!vis[vertex]) {
                        q.add(new pair(vertex, wt));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Example usage of the spanningTree method
        int v = 4; // Number of vertices
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (adjacency list representation)
        addEdge(adj, 0, 1, 10);
        addEdge(adj, 0, 2, 6);
        addEdge(adj, 0, 3, 5);
        addEdge(adj, 1, 3, 15);
        addEdge(adj, 2, 3, 4);

        int minimumSpanningTreeWeight = spanningTree(v, adj);
        System.out.println("Minimum Spanning Tree Weight: " + minimumSpanningTreeWeight);
    }

    // Helper method to add an edge to the adjacency list
    private static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int u, int v, int wt) {
        adj.get(u).add(new ArrayList<>(2));
        adj.get(u).get(adj.get(u).size() - 1).add(v);
        adj.get(u).get(adj.get(u).size() - 1).add(wt);

        adj.get(v).add(new ArrayList<>(2));
        adj.get(v).get(adj.get(v).size() - 1).add(u);
        adj.get(v).get(adj.get(v).size() - 1).add(wt);
    }
}
