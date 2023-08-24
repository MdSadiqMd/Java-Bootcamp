import java.util.Arrays;

public class One_Plus {
    public static void modifyArray(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            if (arr[0] == 0 ) {
                arr[0] = 1;
                break;
            }
            if (arr[arr.length-1] == 0 ) {
                arr[arr.length-1] = 1;
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int n1 = 10;
        modifyArray(n1, arr1);
        System.out.println("Output 1: " + Arrays.toString(arr1));

        int[] arr2 = {1, 0, 2, 0, 3, 0};
        int n2 = 6;
        modifyArray(n2, arr2);
        System.out.println("Output 2: " + Arrays.toString(arr2));
    }
}
