/*
Given two strings find the length of the Longest substrings can be made
ex: strings --> "zfbcdzb" and "zbcdf"
The possible number of substrings can be made are "zb","bcd" and the longest common substring is "bcd" and the answer is 3 as length of "bcd" is 3
for clear explanation watch https://www.youtube.com/watch?v=hj-HDHwifWs&t=1117s
   |   | z | b | c | d | f |
-------------------------------
   | 0 | 0 | 0 | 0 | 0 | 0 |
-------------------------------
z  | 0 | 1 | 0 | 0 | 0 | 0 |
-------------------------------
b  | 0 | 0 | 2 | 0 | 0 | 0 |
-------------------------------
c  | 0 | 0 | 0 | 3 | 0 | 0 |
-------------------------------
d  | 0 | 0 | 0 | 0 | 4 | 0 |
-------------------------------
z  | 0 | 1 | 0 | 0 | 0 | 0 |
-------------------------------
b  | 0 | 0 | 2 | 0 | 0 | 0 |
-------------------------------
 */
public class Longest_Common_Substring {
    public static int Length(String m,String n){
        int max=0;
        char[] str1=m.toCharArray();
        char[] str2=n.toCharArray();
        int[][] dp=new int[m.length()][n.length()];
        for(int i=1;i<str1.length;i++){
            for(int j=1;j<str2.length;j++){
                if(str1[i-1]==str2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String m="zfbcdzb";
        String n="zbcdf";
        System.out.println(Length(m,n));
    }
}
