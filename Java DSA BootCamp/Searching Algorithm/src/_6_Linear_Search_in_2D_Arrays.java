import java.util.*;
public class _6_Linear_Search_in_2D_Arrays {
    public static int[] LinearSearch(int[][] array, int k){
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                int count=-1;
                if(k==array[row][col]){
                    return new int[]{row,col}; //***Here we return the index of the element
                }
            }
            System.out.println();
        }
        return new int[]{-1,-1};//if not present we return the -1,-1
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

        System.out.println("Enter the Element to be Searched:");
        int k= scanner.nextInt();

        int[] result = LinearSearch(array, k);

        if (result[0] != -1 && result[1] != -1) {
            System.out.println("Element found at index: [" + result[0] + "][" + result[1] + "]");
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
