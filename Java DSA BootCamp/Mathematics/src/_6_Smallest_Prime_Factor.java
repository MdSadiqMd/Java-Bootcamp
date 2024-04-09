import java.util.ArrayList;
import java.util.List;

public class _6_Smallest_Prime_Factor {
    public static ArrayList<Integer> primeFactors(int n){
        ArrayList<Integer> ans=new ArrayList<>();
        int[] primes=new int[(int) (Math.pow(10,5)+1)];
        for(int i=0;i<=Math.pow(10,5);i++) primes[i]=i;
        for(int i=2;i*i<=Math.pow(10,5);i++){
            if(primes[i]==i){
                for(int j=i*i;j<=Math.pow(10,5);j+=i){
                    if(primes[j]==j) primes[j]=i;
                }
            }
        }
        while(n!=1){
            ans.add(primes[n]);
            n=n/primes[n];
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(primeFactors(10));
    }
}
