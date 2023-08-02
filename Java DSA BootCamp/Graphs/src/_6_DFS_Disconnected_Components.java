import java.util.ArrayList;

/*
Changes from Previous Code:
We Iteratively Feed the Current Node with Recursion Loop in Main Method
 */
public class _6_DFS_Disconnected_Components {
    static class Edge3 {
        int src;
        int dest;

        public Edge3(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge3> graph[]) {
        graph[0].add(new Edge3(0, 2));
        graph[1].add(new Edge3(1, 2));
        graph[1].add(new Edge3(1, 3));
        graph[2].add(new Edge3(2, 0));
        graph[2].add(new Edge3(2, 1));
        graph[2].add(new Edge3(2, 3));
        graph[3].add(new Edge3(3, 1));
        graph[3].add(new Edge3(3, 2));
        graph[4].add(new Edge3(4, 5));
        graph[5].add(new Edge3(5, 4));
    }

    public static void DFS(ArrayList<Edge3> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge3 e = graph[curr].get(i);
            if (!vis[e.dest]) {
                DFS(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge3> graph[] = new ArrayList[v];

        // Initialize each element of the graph array as an ArrayList
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge3>();
        }

        CreateGraph(graph);

        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                DFS(graph, i, vis);
            }
        }
    }
}
