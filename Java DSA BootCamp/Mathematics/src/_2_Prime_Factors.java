import java.util.ArrayList;

public class _2_Prime_Factors {
    public static ArrayList<Integer> factor(int n){
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                ans.add(i);
                while(n%i==0) n=n/i;
            }
        }
        if(n!=1) ans.add(n);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(factor(10));
    }
}
