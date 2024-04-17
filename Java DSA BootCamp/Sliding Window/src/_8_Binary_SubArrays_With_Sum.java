import java.util.ArrayList;
import java.util.Arrays;

public class _8_Binary_SubArrays_With_Sum {
    public static int sum(ArrayList<Integer> arr,int k){
        if(k<0) return 0;
        int l=0,r=0,sum=0,count=0;
        while(r<arr.size()){
            sum+=arr.get(r);
            while(sum>k){
                sum-=arr.get(l);
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(sum(new ArrayList<>(Arrays.asList(1,0,0,1,1,0)),2));
    }
}
