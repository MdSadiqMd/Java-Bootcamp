import java.util.ArrayList;

public class _1_Square_Root_Method {
    // Prime or Not, GCD of Two Numbers --> https://takeuforward.org/data-structure/check-if-a-number-is-prime-or-not/, https://takeuforward.org/data-structure/find-gcd-of-two-numbers/
    public static ArrayList<Integer> divisors(int n){
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0) {
                ans.add(i);
                if((n/i)!=i) ans.add(n/i);
            }
        }
        return ans;
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
    public static int gcd(int n,int m){
        while(n>0 && m>0){
            if(n>m) n=n%m;
            else m=m%n;
        }
        if(n==0) return m;
        else return n;
    }
    public static void main(String[] args) {
        int n=20,m=40;
        System.out.println(divisors(n));
        System.out.println(prime(n));
        System.out.println(gcd(n,m));
    }
}
