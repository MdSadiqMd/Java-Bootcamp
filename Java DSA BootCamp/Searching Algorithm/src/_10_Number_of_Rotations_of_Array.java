public class _10_Number_of_Rotations_of_Array {
    // Count Number of Rotations of the Array --> https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/
    public static int count(int[] arr) {
        int l=0,h=arr.length-1,ans=Integer.MAX_VALUE,ind=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[l]<=arr[h]){
                if(arr[l]<ans){
                    ind=l;
                    ans=arr[l];
                }
                break;
            } else if(arr[l]<=arr[mid]){
                if(arr[l]<ans){
                    ind=l;
                    ans=arr[l];
                }
                l=mid+1;
            } else {
                if(arr[mid]<ans){
                    ind=mid;
                    ans=arr[mid];
                }
                h=mid-1;
            }
        }
        return ind;
    }
    public static int countRecursive(int[] arr,int l,int h){
        if(l==h) return l;
        int mid=l+(h-l)/2;
        if(arr[mid]<arr[mid-1]) return mid;
        if(arr[l]<=arr[mid]) return countRecursive(arr,mid+1,h);
        else return countRecursive(arr,l,mid-1);
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2};
        System.out.println(count(arr));
        System.out.println(countRecursive(arr,0,arr.length-1));
    }
}
