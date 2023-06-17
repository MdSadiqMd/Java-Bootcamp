import java.util.*;
/*
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

**Explanation:** The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1
 */
public class Adding_two_UnSorted_Array {
    public static int[] Sum(int[] arr1, int[] arr2, int n, int m){
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[n+m];
        for(int i=0;i<m;i++){
            arr[i]=arr1[i];
        }
        for(int j=0;j<n;j++){
            arr[j+m]=arr2[j];
        }
        return arr;
    }
    public static int[] Sorting(int[] result){
        for(int i=0;i<result.length;i++){
            boolean swap=false;
            for(int j=0;j<result.length-i-1;j++){  // j< not j<=
                //here we write -i-1 ,Because as we neglect the last elements after swapping
                if(result[j]>result[j+1]){
                    int temp=result[j];
                    result[j]=result[j+1];
                    result[j+1]=temp;
                    swap=true; //Sorting takes place
                }
            }
            if(!swap){ //swap==false --> Array is already sorted
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr1={1,2,3,0,0,0};
        int[] arr2={2,5,6};
        int n=3;
        int m=3;
        int[] result=Sum(arr1,arr2,n,m);
        Sorting(result);
        System.out.println(Arrays.toString(result));
    }
}
