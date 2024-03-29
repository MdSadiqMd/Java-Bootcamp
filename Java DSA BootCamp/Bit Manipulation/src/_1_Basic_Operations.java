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
    public static String decimalToBinary(int n){
        int rem,quo=n;
        String binary="";
        while(quo>0){
            rem=quo%2;
            binary=Integer.toString(rem)+binary;
            quo=quo/2;
        }
        return binary;
    }
    public static void main(String[] args) {
        int n=1010;
        String m="1010";
        int k=10;
        binaryToDecimalInt(n);
        binaryToDecimalString(m);
        System.out.println(decimalToBinary(k));
    }
}
