public class _5_Lower_Bound_and_Upper_Bound {
    // Lower Bound (arr[mid]>=k) and Upper Bound (arr[mid]>k) --> https://takeuforward.org/arrays/implement-lower-bound-bs-2/ , https://takeuforward.org/arrays/implement-upper-bound/
    public static int lowerBound(int[] arr,int n,int k){
        int low=0,high=n-1,ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static int lowerBoundRecursive(int[] arr,int k,int l,int h){
        if(l>h) return l;
        int mid=(l+h)/2;
        if(arr[mid]>=k) return lowerBoundRecursive(arr,k,l,mid-1);
        else return lowerBoundRecursive(arr,k,mid+1,h);
    }
    public static int upperBound(int[] arr,int n,int k){
        int low=0,high=n-1,ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static int upperBoundRecursive(int[] arr,int k,int l,int h){
        if(l>h) return l;
        int mid=(l+h)/2;
        if(arr[mid]>k) return upperBoundRecursive(arr,k,l,mid-1);
        else return upperBoundRecursive(arr,k,mid+1,h);
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int n=arr.length;
        int k=9;
        System.out.println(lowerBound(arr,n,k));
        System.out.println(lowerBoundRecursive(arr,k,0,n-1));
        System.out.println(upperBound(arr,n,k));
        System.out.println(upperBoundRecursive(arr,k,0,n-1));
    }
}
