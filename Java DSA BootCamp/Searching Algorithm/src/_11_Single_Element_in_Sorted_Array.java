public class _11_Single_Element_in_Sorted_Array {
    public static int search(int[] arr,int n){
        int l=0,h=n-1;
        if(n==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) return arr[mid];
            if((mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1])) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }
    public static int searchRecursive(int[] arr,int n,int l,int h){
        if(n==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];
        if(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) return arr[mid];
            if((mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1])) return searchRecursive(arr,n,mid+1,h);
            else return searchRecursive(arr,n,l,mid-1);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,4,5};
        System.out.println(search(arr,arr.length));
        System.out.println(searchRecursive(arr,arr.length,0,arr.length-1));
    }
}
