import java.util.ArrayList;

/*
1. Print Current Node
2. Mark True at Current Node
3. Traverse in Neighbours and Print them
 */
public class _5_Depth_First_Search {
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
        int v = 4;
        ArrayList<Edge3> graph[] = new ArrayList[v];

        // Initialize each element of the graph array as an ArrayList
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge3>();
        }

        CreateGraph(graph);

        boolean vis[] = new boolean[v];
        DFS(graph, 0, vis); // Start DFS traversal from node 0
    }
}
