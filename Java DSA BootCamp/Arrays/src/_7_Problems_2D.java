import java.util.Scanner;
public class _7_Problems_2D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of rows=");
        int m = sc.nextInt();
        System.out.print("enter the number of column=");
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        System.out.println("enter the  matrix element=\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 1.
        /*System.out.println("Printing Types of Elements in an 2D Array");
        int positive = 0 , negative = 0 , zero = 0 , odd = 0 , even = 0;
        for(int i = 0 ; i < m  ; i++){
            for(int j = 0 ; j < n  ; j++){
                if(arr[i][j] > 0)positive++;
                if(arr[i][j] < 0)negative++;
                if(arr[i][j] == 0)zero++;
                if((arr[i][j] % 2) == 0)even++;
                if((arr[i][j] % 2) != 0)odd++;
            }
        }

        System.out.println("Number of positives = " + positive);
        System.out.println("Number of negatives = " + negative);
        System.out.println("Number of odds = " + odd);
        System.out.println("Number of evens = " + even);
        System.out.println("Number of zeroes = " + zero);*/

        // 2.
        /*System.out.println("Printing Upper Triangle Elements");
        int c5=0;
        for(int i = 0 ; i < m  ; i++){
            for(int j = 0 ; j < n  ; j++){
                if(i+j<n-1) System.out.print(arr[i][j]+" ");
            }
        }*/

        // 3.
        /*System.out.println("Printing Diagonal Elements ");
        for(int i = 0 ; i < m  ; i++){
            for(int j = 0 ; j < n  ; j++){
                if(i+j == m-1) System.out.print(arr[i][j]+" ");
                else if (i==j) System.out.print(arr[i][j]+" ");
            }
        }*/

        // 4.
        /*System.out.println("Printing Maximum Element in 2D Array");
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = Math.max(arr[i][j], arr[j][i]);
            }
        }
        System.out.println(sum);*/

        // 5.
        System.out.println("Print Elements of Middle Column and Middle Row");
        for (int i = 0; i < m; i++) {
            System.out.println(arr[i][m/2]);
        }
        for (int j = 0; j < n; j++) {
            if(j==n/2){ //not printing middle element again
                System.out.println(arr[n/2][j]);
            }
        }
    }
}
