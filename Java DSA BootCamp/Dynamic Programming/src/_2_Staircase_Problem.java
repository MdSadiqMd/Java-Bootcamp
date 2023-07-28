public class _2_Staircase_Problem {
    public static int countWays(int n){
        int prev1=1,prev2=1,current;
        for(int i=2;i<=n;i++){
            current=prev1+prev2;
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
    public static void main(String[] args) {
        System.out.println("For n=1 "+countWays(1));
        System.out.println("For n=2 "+countWays(2));
        System.out.println("For n=3 "+countWays(3));
        System.out.println("For n=4 "+countWays(4));
    }
}
