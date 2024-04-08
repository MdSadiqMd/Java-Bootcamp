import java.util.ArrayList;
import java.util.Arrays;

public class _5_Count_Primes_in_Range_L_R {
    public static ArrayList<Integer> helper(int r){
        int[] primes=new int[r+1];
        Arrays.fill(primes,1);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=2;i<=r;i++){
            if(primes[i]==1){
                for(int j=2*i;j<=r;j+=i) primes[j]=0;
            }
        }
        for(int i=2;i<=r;i++) if(primes[i]==1) ans.add(i);
        return ans;
    }
    public static int range(int l,int r){ // Using sieve of Eratosthenes
        int count=0;
        ArrayList<Integer> primes=helper(r);
        for(int i=l;i<=r;i++){
            if(i>=2 && primes.contains(i)) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(range(5,10));
    }
}
