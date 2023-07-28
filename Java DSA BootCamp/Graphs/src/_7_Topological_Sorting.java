import java.util.ArrayList;
import java.util.Stack;

public class _7_Topological_Sorting {
    public int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(adj, i, stack, vis);
            }
        }
        int ans[] = new int[v];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int v, Stack<Integer> stack, boolean vis[]) {
        vis[v] = true;
        for (int neighbour : adj.get(v)) {
            if (!vis[neighbour]) {
                dfs(adj, neighbour, stack, vis);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        // Create an example directed acyclic graph (DAG) (adjacency list representation)
        int v = 6; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the DAG for topological sorting
        addEdge(adj, 5, 2);
        addEdge(adj, 5, 0);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);

        _7_Topological_Sorting graph = new _7_Topological_Sorting();
        int[] sortedOrder = graph.topoSort(v, adj);

        // Print the topological sorting order
        System.out.println("Topological Sorting Order:");
        for (int vertex : sortedOrder) {
            System.out.print(vertex + " ");
        }
    }

    // Helper method to add an edge to the adjacency list
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
}
