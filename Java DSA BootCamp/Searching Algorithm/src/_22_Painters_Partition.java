import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _22_Painters_Partition {
    // Painters Partition --> https://takeuforward.org/arrays/painters-partition-problem/
    public static int helper(ArrayList<Integer> arr,int time){
        int n=arr.size(),painters=1,board=0;
        for(int i=0;i<n;i++){
            if(board+arr.get(i)<=time) board+=arr.get(i);
            else{
                painters++;
                board=arr.get(i);
            }
        }
        return painters;
    }
    public static int partition(ArrayList<Integer> arr,int k){
        int l= Collections.max(arr),h=arr.stream().mapToInt(Integer::intValue).sum();
        while(l<=h){
            int mid=l+(h-l)/2;
            if(helper(arr,mid)>k) l=mid+1;
            else h=mid-1;
        }
        return l;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(10,20,30,40));
        int n=arr.size(),k=2;
        System.out.println(partition(arr,k));
    }
}
