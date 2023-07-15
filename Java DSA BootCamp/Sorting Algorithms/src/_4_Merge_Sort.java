/*
We make an array into two halves and sort the two halves, and now we compare elements in two halves and swap them
Time Complexity :
For sorting array to two halves : O(n logn to the base 2)
For Sorting two halves of the array : 1. For Comparisons O(m+n-1)
                                      2. For Swapping O(m+n) --> Worst Case scenario
Space Complexity: O(n) --> Out-place Sorting Algorithm
where m and n are length of two sorted arrays from a complete array
For odd number of elements make halves which are nearly equal
 */
public class _4_Merge_Sort {
    public static void mergeSort(int[] arr,int l,int r){
        if(l<r){
            int mid=l+(r-l)/2;
            //Left sub-array recursive call
            mergeSort(arr,l,mid);
            //Right sub-array recursive call
            mergeSort(arr,mid+1,r);
            //CCombining left and right sorted sub-arrays
            mergeCombine(arr,l,mid,r);
        }
    }
    public static void mergeCombine(int[] arr,int l,int mid,int r){
        //Size of left sub-array
        int n1=mid-l+1;
        //Size of Right sub-array
        int n2=r-mid;

        int[] left=new int[n1];
        int[] right=new int[n2];

        int i,j,k;

        for(i=0;i<n1;i++){
            left[i]=arr[l+i];
        }

        for(j=0;j<n2;j++){
            right[j]=arr[mid+1+j];
        }

        i=0;
        j=0;
        k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i=i+1;
            }
            else{
                arr[k]=right[j];
                j=j+1;
            }
            k=k+1;
        }

        //If the elements of a left sided array remains and right sided elements are completely sorted
        while(i<n1){
            arr[k]=left[i];
            i=i+1;
            k=k+1;
        }
        //If the elements of a right sided array remains and left sided elements are completely sorted
        while(i<n2){
            arr[k]=right[i];
            j=j+1;
            k=k+1;
        }
    }
    public static void printArr(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={50,20,40,90,88,11,13};
        int n=arr.length;
        System.out.println("Array Before Sorting :");
        printArr(arr,n);

        mergeSort(arr,0,n-1);

        System.out.println("Array After Sorting :");
        printArr(arr,n);
    }
}
