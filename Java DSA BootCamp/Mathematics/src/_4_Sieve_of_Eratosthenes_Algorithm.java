import java.util.ArrayList;
import java.util.Arrays;

public class _4_Sieve_of_Eratosthenes_Algorithm {
    public static ArrayList<Integer> algorithm(int n){
        int[] primes=new int[n+1];
        Arrays.fill(primes,1);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(primes[i]==1){
                for(int j=2*i;j<=n;j+=i) primes[j]=0;
            }
        }
        for(int i=2;i<=n;i++) if(primes[i]==1) ans.add(i);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(algorithm(10));
    }
}
