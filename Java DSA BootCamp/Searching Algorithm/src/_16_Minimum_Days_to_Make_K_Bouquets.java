import java.util.Arrays;

public class _16_Minimum_Days_to_Make_K_Bouquets {
    // Minimum Number of Days to Make K Bouquets --> https://takeuforward.org/arrays/minimum-days-to-make-m-bouquets/
    public static boolean helper(int[] arr,int day,int n,int m,int k){
        int count=0,numberBouquets=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=day) count++;
            else{
                numberBouquets+=count/k;
                count=0;
            }
        }
        numberBouquets+=count/k;
        return numberBouquets>=m;
    }
    public static int days(int[] arr,int n,int m,int k){
        Arrays.sort(arr);
        int l=arr[0],h=arr[n-1];
        long val=(long) m*k;
        if(val>n) return -1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(helper(arr,mid,n,m,k)) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
    public static void main(String[] args) {
        int[] arr={7,7,7,7,13,11,12,7};
        int n=arr.length,m=2,k=3;
        System.out.println(days(arr,n,m,k));
    }
}
