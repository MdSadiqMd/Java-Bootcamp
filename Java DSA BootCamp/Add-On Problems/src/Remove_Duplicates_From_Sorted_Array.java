public class Remove_Duplicates_From_Sorted_Array {
    public static int removeDuplicates(char[] arr){
        int index = 0; // Index to track the unique elements
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[index++] = arr[i];
            }
        }
        // Add the last unique element
        arr[index++] = arr[arr.length - 1];
        // Fill the remaining positions with '_'
        for (int i = index; i < arr.length; i++) {
            arr[i] = '_';
        }
        return index;
    }
    public static void main(String[] args) {
        char[] arr={'0', '0', '1', '1', '1', '2', '2', '3', '3', '4'};
        int result=removeDuplicates(arr);
        System.out.println("Updated Array:");
        for (int i = 0; i < result; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nLength of Updated Array: " + result);
    }
}
