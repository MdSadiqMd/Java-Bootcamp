import java.util.ArrayList;
import java.util.Arrays;

public class _25_Find_Row_with_Maximum_Ones {
    // Find Row with Maximum Ones --> https://takeuforward.org/arrays/find-the-row-with-maximum-number-of-1s/
    public static int helper(ArrayList<ArrayList<Integer>> arr,int n,int m){
        int max=0,ind=-1;
        for(int i=0;i<n;i++){
            if(search(arr.get(i),n,m)>max){
                max=search(arr.get(i),n,m);
                ind=i;
            }
        }
        return ind;
    }
    public static int search(ArrayList<Integer> arr,int n,int m){
        int l=0,h=m-1,ans=Integer.MIN_VALUE;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr.get(mid)==1){
                ans=mid;
                h=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(1,1,1)));
        arr.add(new ArrayList<>(Arrays.asList(0,0,1)));
        arr.add(new ArrayList<>(Arrays.asList(0,0,0)));
        int n=3,m=3;
        System.out.println(helper(arr,n,m));
    }
}
