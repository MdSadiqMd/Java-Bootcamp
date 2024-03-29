public class _1_Basic_Operations {
    public static void binaryToDecimalInt(int n){
        int ans=0,rem,i=0;
        while(n!=0){
            rem=n%10;
            n/=10;
            ans+=rem*Math.pow(2,i);
            i++;
        }
        System.out.println(ans);
    }
    public static void binaryToDecimalString(String s){
        int ans=0,ind=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1') ans+=Math.pow(2,ind);
            ind++;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int n=1010;
        String m="1010";
        binaryToDecimalInt(n);
        binaryToDecimalString(m);
    }
}
