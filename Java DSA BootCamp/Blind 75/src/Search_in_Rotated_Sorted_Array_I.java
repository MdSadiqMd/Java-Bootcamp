public class Search_in_Rotated_Sorted_Array_I { // Manipulate the given test case and test it down and note all logics and start solving
    public static int search(int[] arr,int low,int high,int k){
        int mid=(high)-(high-low)/2;
        if(arr[mid]==k) return mid;
        else if(arr[low]<=arr[mid]) {
            if(arr[low]<=k && arr[mid]>=k) return search(arr,low,mid,k);
            else return search(arr,mid,high,k);
        }
        else{
            if(arr[mid]<=k && arr[high]>=k) return search(arr,mid,high,k);
            else return search(arr,low,mid,k);
        }
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0},0,5,7));
    }
}