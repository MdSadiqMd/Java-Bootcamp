public class _7_Search_in_Rotated_Array_I {
    // Search in Rotated Sorted Array for Unique Elements --> https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/
    public static int search(int[] arr,int n,int k){
        int l=0,h=n;
        while (l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==k) return mid;
            if(arr[l]<=arr[mid]){
                if(arr[mid]<=k && k<arr[mid]) h=mid-1;
                else l=mid+1;
            } else {
                if(arr[mid]<k && k<=arr[h]) l=mid+1;
                else h=mid-1;
            }
        }
        return -1;
    }
    public static int searchRecursion(int[] arr,int k,int l,int h){
        int mid=l+(h-l)/2;
        if(arr[mid]==k) return mid;
        if(arr[l]<=arr[mid]){
            if(arr[mid]<=k && k<arr[mid]) return searchRecursion(arr,k,l,mid-1);
            else return searchRecursion(arr,k,mid+1,h);
        } else {
            if(arr[mid]<k && k<=arr[h]) return searchRecursion(arr,k,mid+1,h);
            else return searchRecursion(arr,k,l,mid-1);
        }
    }
    public static void main(String[] args) {
        int[] arr={7,8,9,1,2,3,4,5,6};
        int n=arr.length,k=1;
        System.out.println(search(arr,n,k));
        System.out.println(searchRecursion(arr,k,0,n-1));
    }
}
