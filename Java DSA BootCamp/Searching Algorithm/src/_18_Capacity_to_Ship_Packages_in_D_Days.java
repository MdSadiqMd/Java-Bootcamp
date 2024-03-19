import java.util.Arrays;

public class _18_Capacity_to_Ship_Packages_in_D_Days {
    public static int helper(int[] arr,int n,int k){
        int days=1,load=0;
        for(int i=0;i<=n-1;i++){
            if(load+arr[i]>k){
                days=days+1;
                load=arr[i];
            }
            else load+=arr[i];
        }
        return days;
    }
    public static int capacity(int[] arr,int n,int k,int l,int h){
        while(l<=h){
            int mid=l+(h-l)/2;
            if(helper(arr,n,mid)<=k) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
    public static int capacityRecursive(int[] arr,int n,int k,int l,int h){
        if(l<=h){
            int mid=l+(h-l)/2;
            if(helper(arr,n,mid)<=k) return capacityRecursive(arr,n,k,l,mid-1);
            else return capacityRecursive(arr,n,k,mid+1,h);
        }
        return l;
    }
    public static void main(String[] args) {
        int[] arr={5, 4, 5, 2, 3, 4, 5, 6};
        Arrays.sort(arr);
        int n=arr.length,k=5,l=arr[n-1],sum=0;
        for(int i=0;i<=n-1;i++) sum+=arr[i];
        int h=sum;
        System.out.println(capacity(arr,n,k,l,h));
        System.out.println(capacityRecursive(arr,n,k,l,h));
    }
}
