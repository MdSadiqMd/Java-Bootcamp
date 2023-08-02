import java.util.ArrayList;

public class _8_Cyclic_Detection_Directed_Graph {
    static class Edge5 {
        int src;
        int dest;
        public Edge5(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge5>[] graph, int v) {
        graph[0].add(new Edge5(0, 2));
        graph[1].add(new Edge5(1, 0));
        graph[2].add(new Edge5(2, 3));
        graph[3].add(new Edge5(3, 0));
    }

    public static void DFS(ArrayList<Edge5> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge5 e = graph[curr].get(i);
            if (!vis[e.dest]) {
                DFS(graph, e.dest, vis);
            }
        }
    }

    public static boolean isCyclic(ArrayList<Edge5> graph[],boolean vis[],int curr,boolean rec[] ){
        vis[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge5 e=graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            } else if(!vis[e.dest]){
                if(isCyclic(graph,vis,e.dest,rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge5>[] graph = new ArrayList[v];
        boolean vis[]=new boolean[v];
        boolean rec[]=new boolean[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge5>();
        }
        CreateGraph(graph, v);
        System.out.println(isCyclic(graph,vis,0,rec));
    }
}
