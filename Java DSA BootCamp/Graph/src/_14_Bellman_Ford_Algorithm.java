import java.util.ArrayList;

/*

 */
public class _14_Bellman_Ford_Algorithm {
    static class Edge9{
        int src;
        int dest;
        int wt;
        public Edge9(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void CreateGraph(ArrayList<Edge9> graph[]){
        for(int i=0;i<graph[i].size();i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge9(0, 1, 2));
        graph[0].add(new Edge9(0, 2, 4));
        graph[1].add(new Edge9(1, 2, -4));
        graph[2].add(new Edge9(2, 3, 2));
        graph[3].add(new Edge9(3, 4, 4));
        graph[4].add(new Edge9(4, 1, -1));
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge9> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++) {
            graph[i]=new ArrayList<Edge9>();
        }
        boolean vis[]=new boolean[v];
    }
}
