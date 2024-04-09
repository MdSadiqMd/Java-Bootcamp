import java.util.ArrayList;
import java.util.Arrays;

public class _5_Count_Primes_in_Range_L_R {
    public static ArrayList<Integer> helper(double r){
        double[] primes=new double[(int) (r+1)];
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
    // Using Sieve of Eratosthenes
    public static int range(int l,int r){
        int count=0;
        ArrayList<Integer> primes=helper(r);
        for(int i=l;i<=r;i++){
            if(i>=2 && primes.contains(i)) count++;
        }
        return count;
    }
    // Using Binary Search
    public static int rangeOptimised(int l,int r){
        ArrayList<Integer> primes=helper(r);
        int low=0,high=primes.size()-1,ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(primes.get(mid)>l){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return primes.size()-ans;
    }
    public static void main(String[] args) {
        System.out.println(range(4,10));
        System.out.println(rangeOptimised(4,10));
    }
}
