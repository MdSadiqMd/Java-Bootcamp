import java.util.ArrayList;
import java.util.Scanner;

public class _1_DFS_Using_List {
    public static void dfs(int node, boolean[] Vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        Vis[node] = true;
        ls.add(node);
        for (Integer it : adj.get(node)) {
            if (!Vis[it]) {
                dfs(it, Vis, adj, ls);
            }
        }
    }

    public ArrayList<Integer> dfsGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] Vis = new boolean[V];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, Vis, adj, ls);
        return ls;
    }

    public static void main(String[] args) {
        _1_DFS_Using_List dfsTraversal = new _1_DFS_Using_List();

        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // Number of vertices
        int e = sc.nextInt(); // Number of edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(w);
            adj.get(w).add(u);
        }

        ArrayList<Integer> dfsResult = dfsTraversal.dfsGraph(v, adj);
        System.out.println("DFS Traversal: " + dfsResult);
    }
}
