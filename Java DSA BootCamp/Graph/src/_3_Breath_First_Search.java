import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
1. Print Current Node
2. Set the Visited Neighbours True
3. Add Current Node Neighbours into Queue
 */
public class _3_Breath_First_Search {
    static class Edge2 {
        int src;
        int dest;

        public Edge2(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge2>[] graph) {
        graph[0].add(new Edge2(0, 2));
        graph[1].add(new Edge2(1, 2));
        graph[1].add(new Edge2(1, 3));
        graph[2].add(new Edge2(2, 0));
        graph[2].add(new Edge2(2, 1));
        graph[2].add(new Edge2(2, 3));
        graph[3].add(new Edge2(3, 1));
        graph[3].add(new Edge2(3, 2));
    }

    public static void BFS(ArrayList<Edge2> graph[], int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[v];
        q.add(0); // We had Manually given the Traversal Starting Node Value

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.println(curr);
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge2 e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge2> graph[] = new ArrayList[v];

        // Initialize each element of the graph array as an ArrayList
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge2>();
        }

        CreateGraph(graph);
        BFS(graph, v);
    }
}
