import java.util.Scanner;
public class _7_Binary_Search_in_2D_Arrays {
    public static void BinarySearch(int[][] array, int k) {
        int rows = array.length;
        int columns = array[0].length;
        int low = 0;
        int high = rows * columns - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / columns;
            int column = mid % columns;
            int element = array[row][column];

            if (element == k) {
                System.out.println("Element found at row " + row + " and column " + column);
                return;
            } else if (element < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Element not found in the array.");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] array = new int[rows][columns];

        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println("The entered 2D array is:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Enter the element to be searched:");
        int k = scanner.nextInt();

        BinarySearch(array, k);
    }
}
