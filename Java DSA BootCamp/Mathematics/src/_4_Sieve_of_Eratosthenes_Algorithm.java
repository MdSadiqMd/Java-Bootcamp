import java.util.ArrayList;
import java.util.Arrays;

public class _4_Sieve_of_Eratosthenes_Algorithm {
    // In this algorithm we declare an array of size n and set all indexes to 1, and we start iterating and set the bits to 0 of the index and multiples of the index less than n which are not prime at last we again iterate and return the bits which are set to 1 (prime)
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
    public static ArrayList<Integer> algorithmOptimised(int n){
        int[] primes=new int[n+1];
        Arrays.fill(primes,1);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(primes[i]==1){
                for(int j=i*i;j<=n;j+=i) primes[j]=0;
            }
        }
        for(int i=2;i<=n;i++) if(primes[i]==1) ans.add(i);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(algorithm(10));
        System.out.println(algorithmOptimised(10));
    }
}
