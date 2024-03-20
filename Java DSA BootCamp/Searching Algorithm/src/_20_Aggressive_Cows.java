import java.util.Arrays;

public class _20_Aggressive_Cows {
    // Aggressive Cows --> https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/
    public static boolean helper(int[] arr,int n,int ind,int k){
        int cows=1,last=arr[0];
        for(int i=1;i<=n-1;i++){
            if(arr[i]-last>=ind){
                cows++;
                last=arr[i];
            }
            if(cows>=k) return true;
        }
        return false;
    }
    public static int place(int[] arr,int n,int k){
        int l=0,h=arr[n-1]-arr[0];
        while(l<=h){
            int mid=l+(h-l)/2;
            if(helper(arr,n,mid,k)) l=mid+1;
            else h=mid-1;
        }
        return h;
    }
    public static void main(String[] args) {
        int[] arr={0,3,4,7,10,9};
        int n=arr.length,k=4;
        Arrays.sort(arr);
        System.out.println(place(arr,n,k));
    }
}
