import java.util.Arrays;

public class _2_Must_know_Tricks {
    public static int[] swap(int a,int b){
        a=a^b;
        b=a^b;
        a=a^b;
        return new int[]{a,b};
    }
    public static int checkIthBitSet(int a){
        int i=2;
        return a&(1<<i);
    }
    public static void main(String[] args) {
        int a=1010,b=1101;
        System.out.println(Arrays.toString(swap(a,b)));
        System.out.println(checkIthBitSet(a));
    }
}
