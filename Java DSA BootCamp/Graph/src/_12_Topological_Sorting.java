import java.util.ArrayList;
import java.util.Stack;

/*
Topological Sorting can be only Performed Upon Directed Acyclic Graphs (Should not contain any cycle and should be Directed)
 */
public class _12_Topological_Sorting {
    static class Edge7 {
        int src;
        int dest;

        public Edge7(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge7> graph[], int v) {
        graph[0].add(new Edge7(0, 2));
        graph[1].add(new Edge7(1, 2));
        graph[1].add(new Edge7(1, 3));
        graph[2].add(new Edge7(2, 0));
        graph[2].add(new Edge7(2, 1));
        graph[2].add(new Edge7(2, 3));
        graph[3].add(new Edge7(3, 1));
        graph[3].add(new Edge7(3, 2));
    }

    public static void topoSortDFS(ArrayList<Edge7> graph[], int curr, boolean vis[], Stack<Integer> stack) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge7 e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topoSortDFS(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge7> graph[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge7>();
        }
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[v];
        CreateGraph(graph, v);
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topoSortDFS(graph, i, vis, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
