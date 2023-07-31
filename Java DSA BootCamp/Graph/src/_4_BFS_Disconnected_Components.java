import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Changes From Previous Code:
1. Boolean Visited Array Will be in Main Method
2. The Starting Node will be selected Using Loop
 */
public class _4_BFS_Disconnected_Components {
    static class Edge2 {
        int src;
        int dest;

        public Edge2(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public static void CreateGraph(ArrayList<_3_Breath_First_Search.Edge2>[] graph) {
        graph[0].add(new _3_Breath_First_Search.Edge2(0, 2));
        graph[1].add(new _3_Breath_First_Search.Edge2(1, 2));
        graph[1].add(new _3_Breath_First_Search.Edge2(1, 3));
        graph[2].add(new _3_Breath_First_Search.Edge2(2, 0));
        graph[2].add(new _3_Breath_First_Search.Edge2(2, 1));
        graph[2].add(new _3_Breath_First_Search.Edge2(2, 3));
        graph[3].add(new _3_Breath_First_Search.Edge2(3, 1));
        graph[3].add(new _3_Breath_First_Search.Edge2(3, 2));
        //Another Graph
        graph[4].add(new _3_Breath_First_Search.Edge2(4, 5));
        graph[5].add(new _3_Breath_First_Search.Edge2(5, 4));
    }
    public static void BFS(ArrayList<_3_Breath_First_Search.Edge2> graph[], int v,boolean vis[],int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start); // We Automate the Traversal Starting Node Value

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.println(curr);
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    _3_Breath_First_Search.Edge2 e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<_3_Breath_First_Search.Edge2> graph[] = new ArrayList[v];

        // Initialize each element of the graph array as an ArrayList
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<_3_Breath_First_Search.Edge2>();
        }

        CreateGraph(graph);

        boolean vis[] = new boolean[v];
        for(int i=0;i<v;i++) {
            BFS(graph, v,vis,i);
        }
    }
}
