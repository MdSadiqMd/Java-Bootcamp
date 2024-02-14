import java.util.Arrays;

public class _32_Edit_Distance_Insertion_Deletion_Replace_Character {
    // Edit Distance Insertion Deletion and Replace Character --> https://takeuforward.org/data-structure/edit-distance-dp-33/

    // Top - Down Approach --> Memoization
    public static int count(int n,int m,String s1,String s2,int[][] dp){

    }
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
    }
}
