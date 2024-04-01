import java.util.Arrays;

public class _2_Must_know_Tricks {
    public static int[] swap(int a,int b){
        a=a^b;
        b=a^b;
        a=a^b;
        return new int[]{a,b};
    }
    public static int checkIthBitSet(int a,int i) {
        return a&(1<<i);
    }
    public static int setIthBit(int a,int i){
        return a|(1<<i);
    }
    public static int clearIthBit(int a,int i){
        return a&~(1<<i);
    }
    public static int toggle(int a,int i){
        return a^(1<<i);
    }
    public static int removeLastSetBit(int a){
        return a&(a-1);
    }
    public static boolean powOf2(int a){
        return (a&(a-1))==0;
    }
    public static int countSetBits(int a){
        int count=0;
        while(a>1){
            count+=a&1;
            a=a>>1;
        }
        if(a==1) count+=1;
        return count;
    }
    public static void main(String[] args) {
        int a=1010,b=1101,c=4;
        System.out.println(Arrays.toString(swap(a,b)));
        System.out.println(Integer.toBinaryString(checkIthBitSet(a,2)));
        System.out.println(Integer.toBinaryString(setIthBit(a,2)));
        System.out.println(Integer.toBinaryString(clearIthBit(a,2)));
        System.out.println(Integer.toBinaryString(toggle(a,2)));
        System.out.println(Integer.toBinaryString(removeLastSetBit(a)));
        System.out.println(powOf2(a));
        System.out.println(countSetBits(a));
    }
}
