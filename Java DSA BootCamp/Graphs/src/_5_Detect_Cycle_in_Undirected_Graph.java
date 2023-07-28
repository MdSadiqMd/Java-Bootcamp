import java.util.ArrayList;
import java.util.Arrays;
public class _5_Detect_Cycle_in_Undirected_Graph {
    public boolean cycle(int v, ArrayList<ArrayList<Integer>> adj) {
        Boolean[] vis = new Boolean[v];
        Arrays.fill(vis, Boolean.FALSE); // Initialize the array with FALSE values
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, Boolean[] vis, int parent) {
        vis[v] = true;
        for (Integer neighbour : adj.get(v)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, adj, vis, v)) {
                    return true;
                }
            } else if (parent != neighbour) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Create an example undirected graph (adjacency list representation)
        int v = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        // Uncomment the line below to add a cycle to the graph
        addEdge(adj, 3, 0);

        _5_Detect_Cycle_in_Undirected_Graph graph = new _5_Detect_Cycle_in_Undirected_Graph();
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
        adj.get(v).add(u);
    }
}
