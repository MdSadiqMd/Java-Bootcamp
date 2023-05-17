import java.util.Scanner;
public class _7_Problems_2D {
    public static void main(String[] args) {
        // 1
        /*Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of rows=");
        int m=sc.nextInt();
        System.out.print("enter the number of column=");
        int n=sc.nextInt();
        int arr[][]=new int[m][n];
        System.out.println("enter the  matrix element=\n");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
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

        // 2
        /*System.out.println("Program to Print Elements above Secondary Diagonal");
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of rows=");
        int m=sc.nextInt();
        System.out.print("enter the number of column=");
        int n=sc.nextInt();
        int arr1[][]=new int[m][n];
        System.out.println("enter the  matrix element=\n");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr1[i][j]=sc.nextInt();
            }
        }
        int c5=0;
        for(int i = 0 ; i < m  ; i++){
            for(int j = 0 ; j < n  ; j++){
                if(i+j<n-1) System.out.print(arr1[i][j]+" ");
            }
        }*/
    }
}
