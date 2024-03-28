import java.util.ArrayList;
import java.util.Arrays;

public class _26_Search_Element_in_2D_Matrix {
    // Search Element in 2D Matrix --> https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/ , https://takeuforward.org/arrays/search-in-a-row-and-column-wise-sorted-matrix/
    public static boolean search(ArrayList<ArrayList<Integer>> arr,int k){
        int n=arr.size(),m=arr.get(0).size(),l=0,h=n-1;
        for(int i=0;i<n;i++){
            if(arr.get(i).get(0)<=k && arr.get(i).get(m-1)>=k){
                while(l<=h){
                    int mid=l+(h-l)/2;
                    if(arr.get(i).get(mid)==k) return true;
                    else if(arr.get(i).get(mid)>=k) h=mid-1;
                    else l=mid+1;
                }
            }
        }
        return false;
    }
    public static boolean searchOptimize(ArrayList<ArrayList<Integer>> arr,int k){
        int n=arr.size(),m=arr.get(0).size(),l=0,h=n*m-1;
        for(int i=0;i<n;i++){
            if(arr.get(i).get(0)<=k && arr.get(i).get(m-1)>=k){
                while(l<=h){
                    int mid=l+(h-l)/2,row=mid/m,col=mid%m;
                    if(arr.get(row).get(col)==k) return true;
                    else if(arr.get(row).get(col)>=k) h=mid-1;
                    else l=mid+1;
                }
            }
        }
        return false;
    }
    public static int[][] searchElement(ArrayList<ArrayList<Integer>> arr,int k){
        int n=arr.size(),row=0,col=n-1;
        while(row<n && col>=0){
            if(arr.get(row).get(col)==k) return new int[][]{{row,col}};
            else if(arr.get(row).get(col)<k) row++;
            else col--;
        }
        return new int[][]{{-1,-1}};
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        arr.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
        arr.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
        int k=6;
        System.out.println(search(arr,k));
        System.out.println(searchOptimize(arr,k));
        System.out.println(Arrays.deepToString(searchElement(arr, k)));
    }
}
