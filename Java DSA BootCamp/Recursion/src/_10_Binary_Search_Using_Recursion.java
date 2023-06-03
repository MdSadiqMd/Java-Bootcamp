import java.util.*;
public class _10_Binary_Search_Using_Recursion {
    public static int BinarySearch(int[] arr,int low,int high,int k){
        int result=-1;
        while(low<=high){
            int mid=low+(high-low);
            if(arr[mid]==k){
                return mid;
            }
            if(arr[mid]<k){
                return BinarySearch(arr,mid+1,high,k);
            }
            else{
                return BinarySearch(arr,low,mid-1,k);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Length of the Array :");
        int n=sc.nextInt();

        int[] arr=new int[n];
        System.out.println("Enter the Elements of the Array :");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the Element to be Searched :");
        int k=sc.nextInt();

        int result=BinarySearch(arr,0,arr.length-1,k);

        if(result==-1){
            System.out.println("Element is not present in the Array");
        }
        else{
            System.out.println("Element in the Index "+result);
        }
    }
}
