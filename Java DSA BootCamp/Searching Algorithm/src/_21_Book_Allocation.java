import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _21_Book_Allocation {
    // Allocating Books --> https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/
    // The Intuition on this problem to apply the Binary search is developed by two factors
    // 1. Linear Search Time Complexity is high
    // 2. When in Question there is Min of Max / Max of Min there is a potential to use Binary Search
    public static int helper(ArrayList<Integer> arr,int n,int mid){
        int students=1,pagesStudent=0;
        for(int i=0;i<n;i++){
            if(pagesStudent+arr.get(i)<=mid) pagesStudent+=arr.get(i);
            else{
                students++;
                pagesStudent=arr.get(i);
            }
        }
        return students;
    }
    public static int count(ArrayList<Integer> arr,int n,int m){
        if(m>n) return -1;
        int l= Collections.max(arr),h=arr.stream().mapToInt(Integer::intValue).sum();
        while(l<=h){
            int mid=l+(h-l)/2;
            if(helper(arr,n,mid)>m) l=mid+1;
            else h=mid-1;
        }
        return l;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n=arr.size(),m=4;
        System.out.println(count(arr,n,m));
    }
}
