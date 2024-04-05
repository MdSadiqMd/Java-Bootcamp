public class _1_Square_Root_Method {
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
        int n=2;
        System.out.println(prime(n));
    }
}
