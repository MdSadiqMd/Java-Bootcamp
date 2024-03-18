import java.util.Arrays;

public class _17_Find_Smallest_Divisor_Given_Threshold {
    // Find the Smallest Divisor with Given Threshold --> https://takeuforward.org/arrays/find-the-smallest-divisor-given-a-threshold/
    public static int helper(int[] arr,int mid,int n){
        int sum=0;
        for(int i=0;i<n;i++)sum+=Math.ceil((double)(arr[i]/(double)(mid)));
        return sum;
    }
    public static int sum(int[] arr,int n,int k){
        if(n>k) return -1;
        Arrays.sort(arr);
        int l=0,h=arr[n-1];
        while(l<=h){
            int mid=l+(h-l)/2;
            if(helper(arr,mid,n)<=k) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int n=arr.length,k=8;
        System.out.println(sum(arr,n,k));
    }
}
