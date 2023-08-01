import java.util.ArrayList;

public class _11_Cyclic_Detection_Undirected_Graph_Disconnected_Components {
    static class Edge6 {
        int src;
        int dest;

        public Edge6(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<_11_Cyclic_Detection_Undirected_Graph_Disconnected_Components.Edge6> graph[], int v) {
        graph[0].add(new _11_Cyclic_Detection_Undirected_Graph_Disconnected_Components.Edge6(0, 2));
        graph[1].add(new _11_Cyclic_Detection_Undirected_Graph_Disconnected_Components.Edge6(1, 0));
        graph[2].add(new _11_Cyclic_Detection_Undirected_Graph_Disconnected_Components.Edge6(2, 3));
        graph[3].add(new _11_Cyclic_Detection_Undirected_Graph_Disconnected_Components.Edge6(3, 0));
    }

    public static boolean isCyclic(ArrayList<_11_Cyclic_Detection_Undirected_Graph_Disconnected_Components.Edge6> graph[], int curr, boolean vis[]) {
        if (!vis[curr]) {
            vis[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                _11_Cyclic_Detection_Undirected_Graph_Disconnected_Components.Edge6 e = graph[curr].get(i);
                if (vis[e.dest]) {
                    return true;
                }
                if (!vis[e.dest] && isCyclic(graph, e.dest, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<_11_Cyclic_Detection_Undirected_Graph_Disconnected_Components.Edge6>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<_11_Cyclic_Detection_Undirected_Graph_Disconnected_Components.Edge6>();
        }
        CreateGraph(graph, v);

        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if(isCyclic(graph,i,vis)){
                    System.out.println("True");
                    break;
                } else{
                    System.out.println("False");
                    break;
                }
            }
        }
    }
}
