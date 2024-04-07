public class _3_Power_Exponential {
    public static long pow(int n,int m){
        long ans=1;
        while(m>0){
            if(m%2==1){
                ans=ans*n;
                m=m-1;
            } else {
                n=n*n;
                m=m/2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(pow(3,5));
    }
}
