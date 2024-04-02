public class _3_Problems_on_Bit_Manipulation {
    public static int bitFlipsToConvertNumber(int a,int b){
        int ans=a^b,count=0;
        for(int i=0;i<=3;i++) if((ans&(1<<i))!=0) count=count+1;
        return count;
    }
    public static void main(String[] args) {
        int a=1110,b=1010;
        System.out.println(Integer.toBinaryString(bitFlipsToConvertNumber(a,b)));
    }
}
