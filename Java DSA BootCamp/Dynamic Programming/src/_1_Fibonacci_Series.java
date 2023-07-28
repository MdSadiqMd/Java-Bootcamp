public class _1_Fibonacci_Series {
    // Top - Down Approach
    public static int fibonacci(int n){
        int a=0,b=1,c;
        if(n==0 || n==1){
            return n;
        }
        else{
            for(int i=2;i<=n;i++){
                c=a+b;
                a=b;
                b=c;
            }
            return b;
        }
    }

    // Bottom - Up Approach
    public static int fibArray(int n,int[] fibSeries){
        if(n==0 || n==1){
            return n;
        } else if (fibSeries[n]!=-1) {
            return fibSeries[n];
        } else {
            return fibArray(n-1,fibSeries)+fibArray(n-2,fibSeries);
        }
    }
    public static int fibonacci_1(int n){
        int[] fibSeries=new int[n+1];
        for(int i=0;i<=n;i++){
            fibSeries[i]=-1; //Keeping the ALl Elements in Array to -1
        }
        return fibArray(n,fibSeries);
    }

    public static void main(String[] args) {
        int n=7;
        System.out.println("Top - Down Approach "+fibonacci(n));
        System.out.println("Bottom - Up Approach "+fibonacci_1(n));
    }
}
