public class _28_Median_of_2D_Matrix {
    // Median in Row Wise Sorted Array --> https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/
    public static int helper(int[] arr,double mid,int n){
        int l=0,h=n-1;
        while(l<=h){
            int mid1=(l+h)>>1;
            if(arr[mid1]<=mid) l=mid1+1;
            else h=mid1-1;
        }
        return l;
    }
    public static double median(int[][] arr,int row,int col){
        double l=1,h=Math.pow(10,9);
        while(l<=h){
            double mid=l+(h-l)/2;
            int count=0;
            for(int i=0;i<row;i++) count+=helper(arr[i],mid,col);
            if(count<=row*col/2) l=mid+1;
            else h=mid-1;
        }
        return l;
    }
    public static double medianRecursive(int[][] arr,int row,int col,double l,double h){
        if(l<=h){
            double mid=l+(h-l)/2;
            int count=0;
            for(int i=0;i<row;i++) count+=helper(arr[i],mid,col);
            if(count<=row*col/2) return medianRecursive(arr,row,col,mid+1,h);
            else return medianRecursive(arr,row,col,l,mid-1);
        }
        return l;
    }
    public static void main(String[] args) {
        int[][] arr={{1, 3, 8},{2, 3, 4},{1, 2, 5}};
        int row=3,col=3;
        System.out.println(Math.ceil(median(arr,row,col)));
        System.out.println(Math.floor(medianRecursive(arr,row,col,0,Math.pow(10,9))));
    }
}
