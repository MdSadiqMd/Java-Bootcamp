import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _22_Painters_Partition {
    // Painters Partition --> https://takeuforward.org/arrays/painters-partition-problem/
    public static int helper(ArrayList<Integer> arr,int time){
        int painters=1,board=0;
        for (Integer index:arr) {
            if (board+index<=time) board+=index;
            else{
                painters++;
                board=index;
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
    public static int partitionRecursive(ArrayList<Integer> arr,int k,int l,int h){
        if(l<=h){
            int mid=l+(h-l)/2;
            if(helper(arr,mid)>k) return partitionRecursive(arr,k,mid+1,h);
            else return partitionRecursive(arr,k,l,mid-1);
        }
        return l;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(10,20,30,40));
        int k=2;
        System.out.println(partition(arr,k));
        System.out.println(partitionRecursive(arr,k,Collections.max(arr),arr.stream().mapToInt(Integer::intValue).sum()));
    }
}
