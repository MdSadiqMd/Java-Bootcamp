import java.util.Scanner;
/*
arr={2,4,5,7}
prefix sum of arr={2,6,11,18}
 */
/*
If the values increases then the time complexity Increases by n times of the digit to be searched and now let's use prefix sum method in _5_
 */
public class _4_Prefix_Sum_Brute_Force {
    public static int FindSumMatrix(int arr[][],int r1,int c1,int r2,int c2){
        int sum=0;
        for(int i=0;i<=r2;i++){
            for(int j=0;j<=c2;j++){
                sum+=arr[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of rows:");
        int m=sc.nextInt();
        System.out.println("Enter Number of Columns:");
        int n=sc.nextInt();

        int arr[][]=new int [m][n];
        System.out.println("Enter the Matrix Elements:");
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int r1,c1,r2,c2;
        System.out.println("Enter Value of r1 Co-ordinate:");
        r1=sc.nextInt();
        System.out.println("Enter Value of c1 Co-ordinate:");
        c1=sc.nextInt();
        System.out.println("Enter Value of r2 Co-ordinate:");
        r2=sc.nextInt();
        System.out.println("Enter Value of c2 Co-ordinate:");
        c2=sc.nextInt();

        int result=FindSumMatrix(arr,r1,c1,r2,c2);
        System.out.println("Sum of Rectangle is "+result);
    }
}
