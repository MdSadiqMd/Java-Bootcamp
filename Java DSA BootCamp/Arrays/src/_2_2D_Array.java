/*
Refer Lesson plan
If array is declared by a[m][n] where m is the number of rows while n is the number of columns, then address
of an element a[i][j] of the array stored in row major order is calculated as,
Address of A [ I ][ J ] = B + W * [ N * ( I – Lr ) + ( J – Lc ) ]
 */
import java.util.Scanner;
public class _2_2D_Array {
    public static void main(String[] args) {
        //Enter Elements in an Array
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number of Rows in 2D Array:");
        int m=sc.nextInt();
        System.out.print("Enter Number of Columns in 2D Array:");
        int n=sc.nextInt();
        int [][] arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=10;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println(arr[i][j]);
            }
        }

        System.out.println("Rotation of Matrix");
    }
}
