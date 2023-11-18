/*
Count Sort is a non-Comparison based Sorting Algorithm\
Usually preferable for only small numbers Sorting
1. Find the largest number in the array
2. Create a new Array of size of the largest Element+1 and enter the frequencies of the Input Array elements in the new Array Created
3. Return the Elements of the Array with respect to frequencies
 */
public class _8_Count_Sort {
    public static void countSort(int[] arr){
       if(arr.length <=1){
           return;
       }
       // Finding Largest Element
       int max=arr[0];
       for(int num:arr){
           if(num>max){
               max=num;
           }
       }
       int[] countArray=new int[max+1];
       // Creating Frequency Array
        for(int num:arr){
            countArray[num]++;
        }
        // Inserting in sorted Order with respect to frequency Array
        int index=0;
        for(int i=0;i<max;i++){
            while(countArray[i]>0){
                arr[index]=i;
                index++;
                countArray[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={3,4,1,3,2,5,2,8};
        countSort(arr);
        for(int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
