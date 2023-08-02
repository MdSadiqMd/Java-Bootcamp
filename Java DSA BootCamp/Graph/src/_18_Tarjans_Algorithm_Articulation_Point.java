import java.util.ArrayList;

/*
Tarjan's algorithm is a graph algorithm used to find articulation points (also known as cut vertices) in an undirected graph. Articulation points are those vertices whose removal increases the number of connected components in the graph, indicating their importance in maintaining the connectivity of the graph.

Algorithm:
1. Initialize necessary data structures and variables.
2. Perform a depth-first search (DFS) traversal of the graph.
3. Update the lowest discovery time of each vertex during DFS.
4. Identify and mark articulation points based on the lowest discovery times.
5. Return the list of articulation points found during the algorithm's execution.
 */
public class _18_Tarjans_Algorithm_Articulation_Point {
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
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }

    private static void findArticulationPoints(int u, int[] disc, int[] low, int[] parent, boolean[] visited, ArrayList<Edge>[] graph, ArrayList<Integer> articulationPoints) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (Edge e : graph[u]) {
            int v = e.dest;
            if (!visited[v]) {
                children++;
                parent[v] = u;
                findArticulationPoints(v, disc, low, parent, visited, graph, articulationPoints);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] >= disc[u] && parent[u] != -1) {
                    articulationPoints.add(u);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (parent[u] == -1 && children > 1) {
            articulationPoints.add(u);
        }
    }

    private static int time = 0;

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[v];
        int[] disc = new int[v];
        int[] low = new int[v];
        int[] parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = -1;
        }

        CreateGraph(graph);

        ArrayList<Integer> articulationPoints = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                findArticulationPoints(i, disc, low, parent, visited, graph, articulationPoints);
            }
        }

        System.out.println("Articulation Points: " + articulationPoints);
    }
}
