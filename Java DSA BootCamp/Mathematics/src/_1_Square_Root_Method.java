public class _1_Square_Root_Method {
    // GCD of Two Numbers, Prime or Not --> https://takeuforward.org/data-structure/find-gcd-of-two-numbers/, https://takeuforward.org/data-structure/check-if-a-number-is-prime-or-not/
    public static int gcd(int n,int m){
        while(n>0 && m>0){
            if(n>m) n=n%m;
            else m=m%n;
        }
        if(n==0) return m;
        else return n;
    }
    public static boolean prime(int n){
        int count=0;
        for(int i=1;i*i<n;i++){
            if(n%i==0){
                count++;
                if((n/i)!=i) count++;
            }
        }
        return count == 2;
    }
    public static void main(String[] args) {
        int n=20,m=40;
        System.out.println(gcd(n,m));
        System.out.println(prime(n));
    }
}
