import java.util.ArrayList;
import java.util.Collections;

class Triple1 implements Comparable<Triple1> {
    int src;
    int dest;
    int weight;

    Triple1(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Triple1 other) {
        return this.weight - other.weight;
    }
}

public class _12_Kruskals_Algorithm_Minimum_Spanning_Tree {
    public static int findParent(int vertex, int[] parent) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        return findParent(parent[vertex], parent);
    }

    public static void union(int u, int v, int[] parent) {
        int parentU = findParent(u, parent);
        int parentV = findParent(v, parent);

        if (parentU != parentV) {
            parent[parentU] = parentV;
        }
    }

    public static ArrayList<Triple1> kruskalsMST(int v, ArrayList<Triple1> edges) {
        Collections.sort(edges); // Sort edges in non-decreasing order of weight
        int[] parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        ArrayList<Triple1> mst = new ArrayList<>();
        for (Triple1 edge : edges) {
            int u = edge.src;
            int v1 = edge.dest;
            int weight = edge.weight;

            int parentU = findParent(u, parent);
            int parentV = findParent(v1, parent);

            if (parentU != parentV) {
                mst.add(edge);
                union(u, v1, parent);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        // Example usage of Kruskal's algorithm
        int v = 4; // Number of vertices

        // Example graph with edges and weights
        ArrayList<Triple1> edges = new ArrayList<>();
        edges.add(new Triple1(0, 1, 10));
        edges.add(new Triple1(0, 2, 6));
        edges.add(new Triple1(0, 3, 5));
        edges.add(new Triple1(1, 3, 15));
        edges.add(new Triple1(2, 3, 4));

        ArrayList<Triple1> mst = kruskalsMST(v, edges);

        System.out.println("Minimum Spanning Tree:");
        for (Triple1 edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + ", Weight: " + edge.weight);
        }
    }
}
