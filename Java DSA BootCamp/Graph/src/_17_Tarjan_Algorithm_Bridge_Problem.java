import java.util.ArrayList;

/*
Tarjan's algorithm is used to find all the bridges in an undirected graph, where a bridge is an edge whose removal increases the number of connected components in the graph. The algorithm efficiently identifies these bridges in linear time complexity.

Tarjan's Algorithm for Bridge Problem:
1. Initialize data structures:
   - Create an empty list to store the bridges.
   - Create arrays for discovery time and lowest reachable ancestor (set initial values to -1).
   - Use a stack for DFS traversal.
2. Perform DFS:
   - Start DFS from a vertex (pick the first unvisited vertex if multiple components exist).
   - Mark vertex as visited, assign discovery time, and update lowest reachable ancestor.
   - Push the vertex onto the stack.
3. Explore adjacent vertices:
   - For each unvisited adjacent vertex:
     - Recursively perform DFS on the adjacent vertex.
     - Update the lowest reachable ancestor of the current vertex.
4. Find Bridges:
   - If the lowest reachable ancestor of the current vertex is greater than the discovery time of its parent:
     - The edge between the current vertex and its parent is a bridge. Add it to the list.
5. Repeat Steps 2-4 for unvisited vertices until all vertices are visited.
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
