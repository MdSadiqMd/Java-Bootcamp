import java.util.PriorityQueue;

public class _23_Minimise_Maximum_Distance_Between_Gas_Stations {
    // Minimise the Maximum Distance Between Gas Stations --> https://takeuforward.org/arrays/minimise-maximum-distance-between-gas-stations/
    public static class pair{
        double first;
        int second;
        pair(double first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static long countPriority(int[] arr,int n,int k){
        int[] cache=new int[n-1];
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.first,a.first));
        for(int i=0;i<n-1;i++) pq.add(new pair(arr[i+1]-arr[i],i));
        for(int stations=1;stations<=k;stations++){
            pair top=pq.poll();
            int ind=top!=null?top.second:0;
            cache[ind]++;
            double initialDifference=(ind==n-2)?0:cache[ind+1]-cache[ind];
            double newDifference=initialDifference/(double)(cache[ind]+1);
            pq.add(new pair(newDifference,ind));
        }
        return (long)(pq.peek()!=null?pq.peek().first:0);
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5};
        int n=arr.length,k=4;
        System.out.println(countPriority(arr,n,k));
    }
}
