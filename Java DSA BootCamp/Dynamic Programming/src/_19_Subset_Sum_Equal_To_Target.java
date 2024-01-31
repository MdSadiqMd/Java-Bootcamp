import java.util.Arrays;

public class _19_Subset_Sum_Equal_To_Target {
    public static boolean sum(int index,int target,int[] arr,int[][] dp){
        if(index==0) return arr[0]==target;
        if(target==0) return true;
        if(dp[index][target]!=-1) return dp[index][target]==0?false:true;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int n=arr.length;
        int k=4;
        int[][] dp=new int[n][k+1];
        for(int[] row:dp) Arrays.fill(row,-1);
    }
}
