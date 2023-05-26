import java.util.Arrays;
/*
Sorting Means to arrange the data in ascending or descending order
In-Place --> Not Taking Extra space to sort
Out-Place --> Taking Extra Space to Sort
Stable Sort --> If the relative order of Array is Retained
Non - Stable Sort --> If the relative order of Array is not Retained
Example for Stable and Non - Stable : Array --> 1  2' 4  3  2" 5
                                      Stable Sort --> 1  2' 2" 3 4 5
                                      Non-Stable Sort --> 1 2" 2' 3 4 5
Working of Bubble Sort --> Let Given an Array  [5,1,3,2,4]
                           Now we consider first two elements 5,1 and compare 5>1 so, more 5 towards right
                           and next compare 5,3 and 5>3 so again shift 5 to right
                           and so on...
                           now later we compare 1,3 and 3>1 so move 3 to right
                           *** We don't Bring 5 into Sorting Process as it had moved to last of the Array through comparison
                           *** If not moved to right then we consider in sorting process
                           Bubble Sort is a Stable Sort
 */
public class _1_Bubble_Sort {
    public static void BubbleSort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            boolean swap=false;
            for(int j=0;j<arr.length-i-1;j++){  // j< not j<=
                                                //here we write -i-1 ,Because as we neglect the last elements after swapping
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true; //Sorting takes place
                }
            }
            if(!swap){ //swap==false --> Array is already sorted
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={5,1,3,2,4};
        BubbleSort(arr);
        System.out.println("The Sorted Array is :");
        System.out.println(Arrays.toString(arr));
    }
}
