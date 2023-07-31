import java.util.ArrayList;

public class _2_Creating_a_Graph_With_Weight {
    static class Edge1{
        int src;
        int dest;
        int wt;
        public Edge1(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void CreateGraph(ArrayList<Edge1> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge1>();
        }
        graph[0].add(new Edge1(0, 2,2));
        graph[1].add(new Edge1(1, 2,10));
        graph[1].add(new Edge1(1, 3,0));
        graph[2].add(new Edge1(2, 0,2));
        graph[2].add(new Edge1(2, 1,10));
        graph[2].add(new Edge1(2, 3,-1));
        graph[3].add(new Edge1(3, 1,0));
        graph[3].add(new Edge1(3, 2,-1));
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge1> graph[]=new ArrayList[v];
        CreateGraph(graph);

        for(int i=0;i<4;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge1 e=graph[i].get(j);
                System.out.println(e.src+" -- "+e.wt+"--> "+e.dest);
            }
        }
    }
}
