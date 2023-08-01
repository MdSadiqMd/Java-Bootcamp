import java.util.ArrayList;

public class _9_Cyclic_Detection_Directed_Graph_Disconnected_Components {
    static class Edge5 {
        int src;
        int dest;

        public Edge5(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<_9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5>[] graph, int v) {
        graph[0].add(new _9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5(0, 2));
        graph[1].add(new _9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5(1, 0));
        graph[2].add(new _9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5(2, 3));
        graph[3].add(new _9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5(3, 0));
    }

    public static void DFS(ArrayList<_9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            _9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5 e = graph[curr].get(i);
            if (!vis[e.dest]) {
                DFS(graph, e.dest, vis);
            }
        }
    }

    public static boolean isCyclic(ArrayList<_9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5> graph[], boolean vis[], int curr, boolean rec[]) {
        if (!vis[curr]) {
            vis[curr] = true;
            rec[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                _9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5 e = graph[curr].get(i);
                if (rec[e.dest] || isCyclic(graph, vis, e.dest, rec)) {
                    return true;
                }
            }
            rec[curr] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<_9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5>[] graph = new ArrayList[v];
        boolean vis[] = new boolean[v];
        boolean rec[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<_9_Cyclic_Detection_Directed_Graph_Disconnected_Components.Edge5>();
        }
        CreateGraph(graph, v);

        boolean hasCycles = false;
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                hasCycles = hasCycles || isCyclic(graph, vis, i, rec);
            }
        }

        System.out.println(hasCycles ? "True" : "False");
    }
}
