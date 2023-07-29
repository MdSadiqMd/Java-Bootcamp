import java.util.Scanner;
/*
Given a A X B matrix with your initial position at the top-left cell, find the number of possible unique paths to reach the bottom-right cell of the matrix from the initial position.
Note: Possible moves can be either down or right at any point in time, i.e., we can move to matrix[i+1][j] or matrix[i][j+1] from matrix[i][j].

Example 1:
Input:
A = 2, B = 2
Output: 2
 */
public class _8_Possible_Number_of_Unique_Paths {
    public static int uniquePaths(int m,int n){
        int dp[][]=new int[m+1][n+1];
        return solve(0,0,m,n,dp);
    }
    public static int solve(int i,int j,int m,int n,int[][] dp){
        if(i==m-1 || j==n-1){
            return 1;
        } else if (i>=m || j>=n) {
            return 0;
        } else if (dp[i][j]!=0) {
            return dp[i][j];
        } else {
            return solve(i+1,j,m,n,dp)+solve(i,j+1,m,n,dp);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number of Rows : ");
        int m=sc.nextInt();
        System.out.print("Enter the Number of Columns : ");
        int n=sc.nextInt();
        System.out.println(uniquePaths(m,n));
    }
}
