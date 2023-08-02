import java.util.ArrayList;

public class _10_Cyclic_Detection_Undirected_Graph {
    static class Edge6 {
        int src;
        int dest;

        public Edge6(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge6> graph[], int v) {
        graph[0].add(new Edge6(0, 2));
        graph[1].add(new Edge6(1, 0));
        graph[2].add(new Edge6(2, 3));
        graph[3].add(new Edge6(3, 0));
    }

    public static boolean isCyclic(ArrayList<Edge6> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge6 e = graph[curr].get(i);
            if (vis[e.dest]) {
                return true;
            }
            if (!vis[e.dest] && isCyclic(graph, e.dest, vis)) {
                return true;
            }
        }
        vis[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        boolean vis[] = new boolean[v];
        ArrayList<Edge6> graph[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge6>();
        }
        CreateGraph(graph, v);
        System.out.println(isCyclic(graph, 0, vis));
    }
}
