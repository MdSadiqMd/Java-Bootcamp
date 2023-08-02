import java.util.ArrayList;
import java.util.PriorityQueue;
/*
Conditions for a Minimum Spanning Tree (MST) in a connected, undirected graph with weighted edges:
1. MST must contain all the vertices of the original graph.
2. MST must form a tree, i.e., no cycles are allowed.
3. MST must have the minimum possible total weight among all spanning trees of the graph.
4. For a graph with N vertices, the MST will have exactly N-1 edges.

Prim's algorithm is a greedy algorithm used to find the Minimum Spanning Tree (MST) of a connected, undirected graph with weighted edges. The MST is a subset of edges that forms a tree, connecting all the vertices with the minimum possible total edge weight.
Here are the steps of Prim's algorithm:
1. Start with an arbitrary vertex as the initial MST. This can be any vertex in the graph.
2. Initialize an empty priority queue (or min-heap) to store candidate edges. The priority queue will store edges with their weights, sorted in ascending order based on the edge weights.
3. Mark the initial vertex as visited and add all the edges connected to it in the priority queue.
4. Repeat the following steps until all vertices are included in the MST:
   a. Extract the edge with the smallest weight from the priority queue. This will be the candidate edge to add to the MST.
   b. Check if the destination vertex of the extracted edge is already visited. If it is not visited, add it to the MST and mark it as visited.
   c. Add all the edges connected to the newly added vertex (destination vertex of the extracted edge) into the priority queue.
5. Once all vertices are included in the MST, the algorithm is complete. The priority queue will be empty, and the MST will be formed by the selected edges.
6. The final MST will contain the minimum weight edges that connect all the vertices of the original graph with the least possible total weight. The MST may not be unique if there are multiple edges with the same minimum weight.

The time complexity of Prim's algorithm is O(E*log(V)), where E is the number of edges and V is the number of vertices in the graph. This makes it efficient even for large graphs.
 */
public class _15_Prims_Algorithm_MST {
    static class Edge10 {
        int src;
        int dest;
        int wt;

        public Edge10(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void CreateGraph(ArrayList<Edge10>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge10(0, 1, 10));
        graph[0].add(new Edge10(0, 2, 15));
        graph[0].add(new Edge10(0, 3, 30));
        graph[1].add(new Edge10(1, 0, 10));
        graph[1].add(new Edge10(1, 3, 40));
        graph[2].add(new Edge10(2, 0, 15));
        graph[2].add(new Edge10(2, 3, 50));
        graph[3].add(new Edge10(3, 1, 40));
        graph[3].add(new Edge10(3, 2, 50));
    }

    static class pair implements Comparable<pair> {
        int node;
        int cost;

        public pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(pair p2) {
            return p2.cost - this.cost;
        }
    }

    public static void prims(ArrayList<Edge10> graph[], int v, boolean vis[]) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0));
        int mincost = 0;
        while (!pq.isEmpty()) {
            pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                mincost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge10 e = graph[curr.node].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println(mincost);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge10>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge10>();
        }
        boolean vis[] = new boolean[v];
        CreateGraph(graph);
        prims(graph, v, vis);
    }
}
