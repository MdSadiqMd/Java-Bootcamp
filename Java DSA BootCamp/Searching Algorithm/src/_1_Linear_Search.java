//Linear Search Means we Search Element by Element equating to the term need to be found
//Can be used in sorted or unsorted array
//But it's sucks if the Length of array is huge
//If asked to search in a particular range of an array then just change the i value in for loop
import java.util.Scanner;
public class _1_Linear_Search {
    public static String LinearSearch(int[] arr, int k, int n){
        int count=-1;
        if(arr.length==0){ //***Here length method don't have brackets as arr is a data structure
            System.out.println("Array is empty");
        }
        for(int i=0;i<n;i++){
            if(arr[i]==k){
                count=i;
                break;
            }
        }
        if(count==-1){
            System.out.println("Element is not present in the Array");
        }
        else{
            System.out.println("Element is present at Index "+count +"\n"+"Element is present in the place "+(count+1));
        }
        return "Execution is Completed";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length of 1D Array");
        int n=sc.nextInt();

        //1D Array
        System.out.println("Enter the Values of 1D Array");
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the element needed to be Searched");
        int k=sc.nextInt();

        String Result=LinearSearch(arr,k,n);

        System.out.println(Result);
    }
}
