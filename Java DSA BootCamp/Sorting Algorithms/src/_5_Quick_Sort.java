/*
Consider a Pivot element (a random element) and segregate the elements greater than pivot element to right and smaller elements to left
Then sort the left side element by taking a pivot element and so on with the right side elements
 */
public class _5_Quick_Sort {
    public static void quickSort(int[] arr,int l,int h){
        if(l<h){
            int m=partition(arr,l,h);
            //Dividing into sub-Problems
            quickSort(arr,l,m-1);
            quickSort(arr,m+1,h);
        }
    }
    public static int partition(int[] arr,int l,int h){
        int pivot=arr[l];
        int i=l;
        for(int j=l+1;j<=h;j++){
            if(arr[j]<=pivot){
                i=i+1;
                //swap(arr[i],arr[j])
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[l];
        arr[l]=arr[i];
        arr[i]=temp;

        return i;
    }
    public static void printArr(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={50,30,70,90,10,34,89,98,13};
        int n=arr.length;

        System.out.println("Array Before Sorting :");
        printArr(arr,n);

        quickSort(arr,0,n-1);

        System.out.println("Array After Sorting :");
        printArr(arr,n);
    }
}
