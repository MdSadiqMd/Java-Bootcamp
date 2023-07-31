import java.util.ArrayList;

public class _7_Print_Path {
    static class Edge4 {
        int src;
        int dest;

        public Edge4(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge4>[] graph) {
        graph[0].add(new Edge4(0, 2));
        graph[1].add(new Edge4(1, 2));
        graph[1].add(new Edge4(1, 3));
        graph[2].add(new Edge4(2, 0));
        graph[2].add(new Edge4(2, 1));
        graph[2].add(new Edge4(2, 3));
        graph[3].add(new Edge4(3, 1));
        graph[3].add(new Edge4(3, 2));
    }

    public static boolean DFS(ArrayList<Edge4> graph[], int curr, int value, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        if (curr == value) {
            return true;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge4 e = graph[curr].get(i);
            if (!vis[e.dest] && DFS(graph, e.dest, value, vis)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int v = 4;

        ArrayList<Edge4>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge4>();
        }
        boolean vis[] = new boolean[v];
        CreateGraph(graph);

        int value = 1;
        for (int i = 0; i < v; i++) {
            if (!vis[i] && DFS(graph, i, value, vis)) {
                break;
            }
        }
    }
}
