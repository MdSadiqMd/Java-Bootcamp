public class _6_Problems_1D {
    public static void main(String[] args) {

        System.out.println("Sum of Elements in even Indexes");
        int [] arr={3,20,4,6,9};
        int sum=0;
        for(int i=0;i<=(arr.length);i=i+2){
            sum=sum+arr[i];
        }
        System.out.println(sum);

        System.out.println("Printing Even Elements in the array");
        int [] arr1={34,21,54,65,43};
        for(int ele:arr1){
            if(ele%2==0){
                System.out.println(ele);
            }
        }

        System.out.println("Printing Largest Element in an Array");
        int [] arr2={4,21,54,65,43};
        int max=Integer.MIN_VALUE;
        for(int ele:arr2){
            max=Math.max(max,ele);
        }
        System.out.println(max);

        System.out.println("Print Second Largest Element in the array");
        int[] arr3 = { 34, 21, 54, 65, 43 };
        int arr_size = arr3.length;
        int i, first, second;
        // There should be at least two elements
        if (arr_size < 2) {
            System.out.printf(" Invalid Input ");
            return;
        }
        int largest = second = Integer.MIN_VALUE;
        // Find the largest element
        for (i = 0; i < arr_size; i++)
            largest = Math.max(largest, arr3[i]);
        // Find the second-largest element
        for (i = 0; i < arr_size; i++) {
            if (arr3[i] != largest)
                second = Math.max(second, arr3[i]);
        }
        if (second == Integer.MIN_VALUE)
            System.out.printf("There is no second " + "largest element\n");
        else {
            System.out.printf("%d\n", second);
        }

        System.out.println("Finding Peak Element");
        int [] arr4={1,3,2,6,5};
        for(int j=0;j<arr4.length-1;j++){
            if(j>0){
                if((arr4[j] > arr4[j - 1]) & (((arr4[j] + 1) == arr4[j + 1]) || ((arr4[j] - 1) == arr4[j + 1]))) {
                    System.out.println(arr4[j]);
                }
            }
        }
    }
}
