public class _9_Minimum_in_Rotated_Sorted_Array {
    // Minimum Element in Rotated Sorted Array --> https://takeuforward.org/data-structure/minimum-in-rotated-sorted-array/
    public static int searchBinary(int[] arr,int n){
        int l=0,h=n-1,ans=Integer.MAX_VALUE;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[l]<=arr[h]){
                ans=Math.min(ans,arr[l]);
                break;
            }
            if(arr[mid]>arr[l]){
                ans=Math.min(ans,arr[l]);
                l=mid+1;
            } else {
                ans=Math.min(ans,arr[mid]);
                h=mid-1;
            }
        }
        return ans;
    }
    public static int searchBinaryRecursive(int[] arr, int l, int h) {
        int mid = l + (h - l) / 2, ans = Integer.MAX_VALUE;
        if (l > h) return Integer.MAX_VALUE;
        if (arr[l] <= arr[h]) return arr[l];
        if (arr[mid] > arr[l]) ans = Math.min(arr[l], searchBinaryRecursive(arr, mid + 1, h));
        else ans = Math.min(arr[mid], searchBinaryRecursive(arr, l, mid - 1));
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={4,5,6,7,8,1,2};
        int n=arr.length;
        System.out.println(searchBinary(arr,n));
        System.out.println(searchBinaryRecursive(arr,0,n-1));
    }
}
