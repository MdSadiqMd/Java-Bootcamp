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
    public static void main(String[] args) {
        int a=1010,b=1101;
        System.out.println(Arrays.toString(swap(a,b)));
        System.out.println(Integer.toBinaryString(checkIthBitSet(a,2)));
        System.out.println(Integer.toBinaryString(setIthBit(a,2)));
        System.out.println(Integer.toBinaryString(clearIthBit(a,2)));
    }
}
