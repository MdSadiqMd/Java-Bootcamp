import java.util.ArrayList;

public class _6_Detect_Cycle_in_Directed_Graph {
    public boolean cycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v];
        boolean rec[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, rec)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] rec) {
        vis[v] = true;
        rec[v] = true;
        for (Integer neighbour : adj.get(v)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, adj, vis, rec)) {
                    return true;
                }
            } else if (rec[neighbour]) {
                return true;
            }
        }
        rec[v] = false;
        return false;
    }

    public static void main(String[] args) {
        // Create an example directed graph (adjacency list representation)
        int v = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph to create a cycle
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        //addEdge(adj, 3, 1); // This edge creates a cycle

        _6_Detect_Cycle_in_Directed_Graph graph = new _6_Detect_Cycle_in_Directed_Graph();
        boolean hasCycle = graph.cycle(v, adj);
        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain any cycle.");
        }
    }

    // Helper method to add an edge to the adjacency list
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
}
