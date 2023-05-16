import java.util.Scanner;

/*
Here we apply column wise Prefix sum
Then the sum of the whole box we take the answer will be last value of the box
 */
public class _5_Prefix_Sum_Optimized_Approach {
    public static int FindSumMatrix(int arr[][],int r1,int c1,int r2,int c2){
        int sum=0;
        for(int i=0;i<=r2;i++){
            for(int j=0;j<=c2;j++){
                sum+=arr[i][j];
                sum=sum+arr[i][j];
            }
        }
        return sum;
    }
    public static int SumRegion(int[][] arr,int r1,int c1,int c2,int r2){
        int sum=0,up=0,left=0,repeated_region=0,result=0;
        sum=arr[r2][c2];
        up=arr[r1-1][c2];
        left=arr[r2][c1-1];
        repeated_region=arr[r1-1][c1-1];
        System.out.println(sum);
        result=sum - up + left - repeated_region;
        return result;
    }
    public static void PrefixSumMatrix(int[][] arr){
        int m=arr.length; //column length
        int n=arr[0].length; //Row length
        //Traverse the array row-wise to calculate Row-wise Prefix Sum
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j]+=arr[i][j-1];
            }
        }
        //Traverse the array column-wise to calculate column wise prefix sum
        for(int j=0;j<n;j++){
            for(int i=1;i<m;i++){
                arr[i][j]+=arr[i-1][j];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of rows:");
        int m = sc.nextInt();
        System.out.println("Enter Number of Columns:");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter the Matrix Elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int r1, c1, r2, c2;
        System.out.println("Enter Value of r1 Co-ordinate:");
        r1 = sc.nextInt();
        System.out.println("Enter Value of c1 Co-ordinate:");
        c1 = sc.nextInt();
        System.out.println("Enter Value of r2 Co-ordinate:");
        r2 = sc.nextInt();
        System.out.println("Enter Value of c2 Co-ordinate:");
        c2 = sc.nextInt();

        PrefixSumMatrix(arr);
        int result = FindSumMatrix(arr, r1, c1, r2, c2);
        System.out.println("Sum of Rectangle is " + result);
    }
}
