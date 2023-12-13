public class Power_of_X {
    public static double myPow(double x,int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 1/(x*myPow(x,-n-1));
        } else{
           return x*myPow(x,n-1);
        }
    }
    public static void main(String[] args) {
        double x=4;
        int n=-2;
        System.out.println(myPow(x,n));
    }
}
