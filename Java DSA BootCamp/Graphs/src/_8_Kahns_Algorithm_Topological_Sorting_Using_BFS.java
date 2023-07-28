import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _8_Kahns_Algorithm_Topological_Sorting_Using_BFS {
    public int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int indeg[] = new int[v];
        for (ArrayList<Integer> list : adj) {
            for (Integer e : list) {
                indeg[e]++;
            }
        }
        boolean vis[] = new boolean[v];
        ArrayList<Integer> ansList = new ArrayList<>();
        bfs(adj, v, v, vis, ansList, indeg);
        int ans[] = new int[v];
        int i = 0;
        for (int e : ansList) {
            ans[i++] = e;
        }
        return ans;
    }

    public void bfs(ArrayList<ArrayList<Integer>> adj, int v, int V, boolean vis[], ArrayList<Integer> ans, int indeg[]) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for (int neighbour : adj.get(cur)) {
                if (--indeg[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }
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

        _8_Kahns_Algorithm_Topological_Sorting_Using_BFS graph = new _8_Kahns_Algorithm_Topological_Sorting_Using_BFS();
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
