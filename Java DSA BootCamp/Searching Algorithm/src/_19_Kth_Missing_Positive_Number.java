public class _19_Kth_Missing_Positive_Number {
    // Kth Missing Positive Number --> https://takeuforward.org/arrays/kth-missing-positive-number/
    public static int find(int[] arr,int n,int k){
        int l=1,h=n-2;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]-(mid+1)>k) h=mid-1;
            else l=mid+1;
        }
        return l+k;
    }
    public static int findRecursive(int[] arr,int n,int k,int l,int h){
        if(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]-(mid+1)>k) return findRecursive(arr,n,k,l,mid-1);
            else return findRecursive(arr,n,k,mid+1,h);
        }
        return l+k;
    }
    public static void main(String[] args) {
        int[] arr={2,3,4,6,9,11};
        int n=arr.length,k=5;
        System.out.println(find(arr,n,k));
        System.out.println(findRecursive(arr,n,k,1,n-2));
    }
}
