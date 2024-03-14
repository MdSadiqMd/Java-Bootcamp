public class _12_Peak_Element {
    // Find Peak Element --> https://takeuforward.org/data-structure/peak-element-in-array/
    public static int search(int[] arr,int n){
        int l=1,h=n-2;
        if(n==1 || arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return 0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) return mid;
            if(arr[mid-1]>arr[mid]) h=mid-1;
            else l=mid+1;
        }
        return -1;
    }
    public static int searchRecursive(int[] arr,int n,int l,int h){
        if(n==1 || arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return 0;
        if(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) return mid;
            if(arr[mid-1]>arr[mid]) return searchRecursive(arr,n,l,mid-1);
            else return searchRecursive(arr,n,mid+1,h);
        }
        else return -1;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        int n=arr.length;
        System.out.println(search(arr,n));
        System.out.println(searchRecursive(arr,n,1,n-2));
    }
}
