public class _8_Search_in_Rotated_Array_II {
    // Search in Rotated Array with Duplicates --> https://takeuforward.org/arrays/search-element-in-rotated-sorted-array-ii/
    public static boolean search(int[] arr,int n,int k){
        int l=0,h=n-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==k) return true;
            if(arr[mid]==arr[l] && arr[mid]==arr[h]){
                l=l+1;
                h=h-1;
                continue;
            }
            if(arr[l]<=arr[mid]){
                if(arr[mid]<=k && k<arr[mid]) h=mid-1;
                else l=mid+1;
            } else {
                if(arr[mid]<k && k<=arr[h]) l=mid+1;
                else h=mid-1;
            }
        }
        return false;
    }
    public static boolean searchRecursion(int[] arr,int k,int l,int h){
        int mid=l+(h-l)/2;
        if(l>h) return false;
        if(arr[mid]==k) return true;
        if(arr[l]<=arr[mid]){
            if(arr[mid]<=k && k<arr[mid]) searchRecursion(arr,k,l,mid-1);
            else searchRecursion(arr,k,mid+1,h);
        } else {
            if(arr[mid]<k && k<=arr[h]) searchRecursion(arr,k,mid+1,h);
            else searchRecursion(arr,k,l,mid-1);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int n=arr.length,k=3;
        System.out.println(search(arr,n,k));
        System.out.println(searchRecursion(arr,k,0,n-1));
    }
}
