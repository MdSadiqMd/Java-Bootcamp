import java.util.ArrayList;
import java.util.Arrays;

public class _27_Find_Peak_Element_II {
    public static int helper(ArrayList<ArrayList<Integer>> arr,int col){
        int max=-1,ind=-1;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).get(col)>max){
                max=arr.get(i).get(col);
                ind=i;
            }
        }
        return ind;
    }
    public static int[][] peak(ArrayList<ArrayList<Integer>> arr){
        int m=arr.get(0).size(),l=0,h=m-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int row=helper(arr,mid);
            int left=mid-1>=0 ? arr.get(row).get(mid-1) : -1;
            int right=mid+1<0 ? arr.get(row).get(mid+1) : -1;
            if(arr.get(row).get(mid)>left && (arr.get(row).get(mid)>right)) return new int[][]{{row,mid}};
            else if(arr.get(row).get(mid)<left) h=mid-1;
            else l=mid+1;
        }
        return new int[][]{{-1,-1}};
    }
    public static int[][] peakRecursive(ArrayList<ArrayList<Integer>> arr,int l,int h){
        if(l<=h){
            int mid=l+(h-l)/2;
            int row=helper(arr,mid);
            int left=mid-1>=0 ? arr.get(row).get(mid-1) : -1;
            int right=mid+1<0 ? arr.get(row).get(mid+1) : -1;
            if(arr.get(row).get(mid)>left && (arr.get(row).get(mid)>right)) return new int[][]{{row,mid}};
            else if(arr.get(row).get(mid)<left) return peakRecursive(arr,l,mid-1);
            else return peakRecursive(arr,mid+1,h);
        }
        return new int[][]{{-1,-1}};
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(4,2,5,1,4,5)));
        arr.add(new ArrayList<>(Arrays.asList(2,9,3,2,3,2)));
        arr.add(new ArrayList<>(Arrays.asList(1,7,6,0,1,3)));
        arr.add(new ArrayList<>(Arrays.asList(3,6,2,3,7,2)));
        System.out.println(Arrays.deepToString(peak(arr)));
        System.out.println(Arrays.deepToString(peakRecursive(arr,0, arr.get(0).size()-1)));
    }
}
