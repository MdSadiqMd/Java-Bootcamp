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
            if(n>2) break;
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
        System.out.println(divisors(20));
        System.out.println(prime(20));
        System.out.println(gcd(20,40));
    }
}
