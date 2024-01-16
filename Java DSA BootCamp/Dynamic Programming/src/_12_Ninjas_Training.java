import java.util.Arrays;
// https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/
public class _12_Ninjas_Training {
    // Top - Down Approach --> Memoization
    public static int solve(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        if (day == 0) {
            int max = 0;
            for (int i = 0; i <= 2; i++) {
                max = Math.max(max, points[0][i]);
            }
            return dp[day][last] = max;
        }
        int max = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + solve(day - 1, i, points, dp);
                max = Math.max(max, activity);
            }
        }
        return dp[day][last] = max;
    }
    // Bottom - Up Approach --> Tabulation
    public static int solveTab(int n,int[][] points){
        int[][] dp=new int[n][4];
        dp[0][0]=Math.max(points[0][1],points[0][2]);
        dp[0][1]=Math.max(points[0][0],points[0][2]);
        dp[0][2]=Math.max(points[0][0],points[0][1]);
        dp[0][3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        for (int day=1;day<n;day++){
            for(int last=0;last<4;last++){
                dp[day][last]=0;
                for (int task=0;task<=2;task++){
                    if(task!=last){
                        int activity=points[day][task]+dp[day-1][task];
                        dp[day][last]=Math.max(dp[day][last],activity);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    // Space Optimization
    public static int solveSpace(int n,int[][] points){
        int[] prev=new int[4];
        prev[0]=Math.max(points[0][1],points[0][2]);
        prev[1]=Math.max(points[0][0],points[0][2]);
        prev[2]=Math.max(points[0][0],points[0][1]);
        prev[3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        for(int day=1;day<n;day++){
            int[] temp=new int[4];
            for(int last=0;last<4;last++){
                temp[last]=0;
                for(int task=0;task<=2;task++){
                    if(task!=last){
                        temp[last]=Math.max(temp[last],points[day][task]+prev[task]);
                    }
                }
            }
            prev=temp;
        }
        return prev[3];
    }
    public static void main(String[] args) {
        int[][] points = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
        int n = points.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(n - 1, 0, points, dp));
        System.out.println(solveTab(n,points));
        System.out.println(solveSpace(n,points));
    }
}
