import java.util.ArrayList;

/*
Tarjan's algorithm finds strongly connected components (SCCs) in a directed graph.

Algorithm:
1. Initialize a stack, a counter, and arrays to track traversal order, low-link values, and visited vertices.
2. Perform a DFS traversal on the graph:
   - Assign traversal order and low-link values to each visited vertex.
3. During the DFS, identify SCCs:
   - Push each visited vertex onto the stack.
   - Update low-link values based on neighbors' values.
   - If traversal order matches the low-link value for a vertex, pop elements from the stack to form an SCC.
4. Continue DFS traversal until all vertices are visited.
5. The stack contains the SCCs when the algorithm finishes.
6. End of the algorithm.

The algorithm efficiently identifies and groups strongly connected components in a directed graph.
 */
public class _17_Tarjan_Algorithm_Bridge_Problem {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean vis[], int dt[], int low[], int time, int parent) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == parent) {
                continue;
            } else if (!vis[e.dest]) {
                DFS(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] < low[e.dest]) {
                    System.out.println("Bridge is " + curr + " --> " + e.dest);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge> graph[], int v, boolean vis[]) {
        int dt[] = new int[v];
        int low[] = new int[v];
        int time = 0;
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                DFS(graph, i, vis, dt, low, time, -1);
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        CreateGraph(graph);
        boolean[] vis = new boolean[v];
        getBridge(graph, v, vis);
    }
}
