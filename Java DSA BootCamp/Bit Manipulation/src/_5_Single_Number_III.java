import java.util.Arrays;

public class _5_Single_Number_III {
    public static long[] search(int[] arr){
        long xor=0,b1=0,b2=0;
        for(int i=0;i<=arr.length-1;i++) xor=xor^arr[i];
        long rightMostBit=(xor^xor-1)&xor;
        for(int i=0;i<=arr.length-1;i++){
            if((arr[i]&rightMostBit)!=0) b1=b1^arr[i];
            else b2=b2^arr[i];
        }
        return new long[]{b1,b2};
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,5,5,6};
        System.out.println(Arrays.toString(search(arr)));
    }
}
