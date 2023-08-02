import java.util.ArrayList;
import java.util.Stack;

/*
Kosaraju's algorithm is a graph algorithm used to find the strongly connected components (SCCs) in a directed graph.
Approach:
1. Get Nodes in Stack (topological sort)
2. Transpose the graph
3. Do DFS according to stack nodes on the transpose graph
Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph. This is because it performs two DFS traversals on the graph.
*/
public class _16_Kosaraju_Algorithm {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                DFS(graph, e.dest, vis);
            }
        }
    }

    public static void toposort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                toposort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void kosaraju(ArrayList<Edge> graph[], int v, boolean vis[]) {
        // Sorting the Nodes
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                toposort(graph, i, vis, s);
            }
        }
        // Making a Transpose Graph
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for (int i = 0; i < transpose.length; i++) { // This loop makes the Array List null and Visited array also initialize with false to us to reuse in DFS on Transpose Graph
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src)); // This Line creates and Transpose graph
            }
        }
        // Applying DFS on Transpose Graph
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                DFS(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        CreateGraph(graph);
        boolean[] vis = new boolean[v];
        kosaraju(graph, v, vis);
    }
}
