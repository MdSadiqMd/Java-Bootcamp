import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _9_SubArray_With_K_Different_Integers {
    public static int count(ArrayList<Integer> arr,int k){
        int l=0,r=0,count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<arr.size()){
            map.put(arr.get(r),map.getOrDefault(arr.get(r),0)+1);
            while(map.size()>k){
                map.put(arr.get(l),map.getOrDefault(arr.get(r),0)+1);
                if(map.get(arr.get(l))==0) map.remove(arr.get(l));
                l--;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(count(new ArrayList<>(Arrays.asList(1,2,3,1)),3));
    }
}
