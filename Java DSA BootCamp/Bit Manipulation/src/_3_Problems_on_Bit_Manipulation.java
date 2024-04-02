import java.util.ArrayList;

public class _3_Problems_on_Bit_Manipulation {
    public static int bitFlipsToConvertNumber(int a,int b){
        int ans=a^b,count=0;
        for(int i=0;i<=3;i++) if((ans&(1<<i))!=0) count=count+1;
        return count;
    }
    public static ArrayList<ArrayList<Integer>> powerSet(int[] arr){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<(1<<arr.length);i++){
            for(int j=0;j<arr.length-1;j++) if((i&(1<<j))!=0) list.add(arr[j]);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
    public static int singleNumber(int[] arr){
        int ans=0;
        for(int i=0;i<=arr.length-1;i++) ans=ans^arr[i];
        return ans;
    }
    public static void main(String[] args) {
        int a=1110,b=1010;
        int[] arr={1,2,2,3,3};
        System.out.println(Integer.toBinaryString(bitFlipsToConvertNumber(a,b)));
        System.out.println(powerSet(arr));
        System.out.println(singleNumber(arr));
    }
}
