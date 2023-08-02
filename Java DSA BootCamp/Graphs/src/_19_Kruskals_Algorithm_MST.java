import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Kruskal's algorithm is a greedy algorithm used to find the Minimum Spanning Tree (MST) in a connected, undirected graph. The Minimum Spanning Tree is a subset of the edges of the graph that forms a tree, connecting all the vertices together with the minimum total edge weight possible

Algorithm:
1. Define a find function to find the parent (representative) of a set in the disjoint-set data structure. This function will be used to check for cycles during MST construction.
2. Define a union function to merge two sets in the disjoint-set data structure.
3. Implement Kruskal's algorithm to find the MST by sorting all the edges in ascending order of their weights and including them in the MST if they don't create a cycle
 */
public class _19_Kruskals_Algorithm_MST {
    public class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Find function for disjoint-set (used to check for cycles)
    private int find(int[] parent, int node) {
        if (parent[node] == -1)
            return node;
        return find(parent, parent[node]);
    }

    // Union function for disjoint-set
    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        if (xSet != ySet)
            parent[xSet] = ySet;
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new _19_Kruskals_Algorithm_MST().new Edge(0, 1, 10));
        graph[0].add(new _19_Kruskals_Algorithm_MST().new Edge(0, 2, 6));
        graph[0].add(new _19_Kruskals_Algorithm_MST().new Edge(0, 3, 5));
        graph[1].add(new _19_Kruskals_Algorithm_MST().new Edge(1, 3, 15));
        graph[2].add(new _19_Kruskals_Algorithm_MST().new Edge(2, 3, 4));
    }

    public void findMST(ArrayList<Edge>[] graph) {
        int v = graph.length;
        ArrayList<Edge> edges = new ArrayList<>();

        // Gather all edges into a single list
        for (ArrayList<Edge> list : graph) {
            edges.addAll(list);
        }

        // Sort the edges in ascending order of their weights
        Collections.sort(edges, Comparator.comparingInt(e -> e.wt));

        int[] parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = -1; // Initialize each node as its own set
        }

        ArrayList<Edge> mstEdges = new ArrayList<>();

        for (Edge edge : edges) {
            int srcSet = find(parent, edge.src);
            int destSet = find(parent, edge.dest);

            if (srcSet != destSet) {
                // Include the edge in MST and merge the sets
                mstEdges.add(edge);
                union(parent, srcSet, destSet);
            }
        }

        // Print the Minimum Spanning Tree
        System.out.println("Minimum Spanning Tree (MST) Edges:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " - " + edge.dest + ", Weight: " + edge.wt);
        }
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] vis = new boolean[v];

        CreateGraph(graph);

        _19_Kruskals_Algorithm_MST kruskal = new _19_Kruskals_Algorithm_MST();
        kruskal.findMST(graph);
    }

}
