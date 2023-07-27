import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2_BFS_Using_List {
    public ArrayList<Integer> bfsGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] Vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        Vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (!Vis[it]) {
                    Vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        _2_BFS_Using_List bfsTraversal = new _2_BFS_Using_List();

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

        ArrayList<Integer> bfsResult = bfsTraversal.bfsGraph(v, adj);
        System.out.println("BFS Traversal: " + bfsResult);
    }
}
