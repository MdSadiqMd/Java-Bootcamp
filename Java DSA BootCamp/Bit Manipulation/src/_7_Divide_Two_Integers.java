public class _7_Divide_Two_Integers {
    public static long division(int dividend,int divisor){
        boolean sign=true;
        if(dividend==divisor) return 1;
        if(dividend>=0&divisor<0) sign=false;
        if(dividend<0&divisor>0) sign=false;
        long n=Math.abs((long) dividend),m=Math.abs((long) divisor),count,ans=0;
        while(n>=m){
            count=0;
            while(n>=(m<<(count+1))) count++;
            ans+=(1L <<count);
            n=n-(m*(1L <<count));
        }
        if(ans>=(1L <<31)&&sign) return Integer.MAX_VALUE;
        if(ans>= 1L <<31) return Integer.MIN_VALUE;
        return sign?ans:-ans;
    }
    public static void main(String[] args) {
        int dividend=7,divisor=2;
        System.out.println(division(dividend,divisor));
    }
}
