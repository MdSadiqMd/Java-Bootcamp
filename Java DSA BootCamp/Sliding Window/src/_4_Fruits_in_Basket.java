import java.util.HashMap;

public class _4_Fruits_in_Basket {
    public static int length(int[] arr,int baskets){
        int l=0,r=0,len=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<arr.length){
            map.put(arr[r],map.getOrDefault(arr[0],0)+1);
            if(map.size()>baskets){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0) map.remove(arr[l]);
                l++;
            }
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(length(new int[]{3,3,3,1,2,1,1,1,1,3,4},2));
    }
}
