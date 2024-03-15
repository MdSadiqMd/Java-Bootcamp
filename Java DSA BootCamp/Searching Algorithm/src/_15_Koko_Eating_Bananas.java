public class _15_Koko_Eating_Bananas {
    // Koko Eating Bananas --> https://takeuforward.org/binary-search/koko-eating-bananas/
    public static int helper(int[] arr,int mid){
        int total=0;
        for(int val:arr) total= (int)(total+Math.ceil((double)val/mid));
        return total;
    }
    public static int search(int[] arr,int n,int deadline){
        int l=1,h=arr[n-1];
        while(l<=h){
            int mid=l+(h-l)/2;
            if(helper(arr,mid)<=deadline) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
    public static int searchRecursive(int[] arr,int l,int h,int deadline){
        if(l>h) return l;
        int mid=l+(h-l)/2;
        if(helper(arr,mid)<=deadline) return searchRecursive(arr,l,mid-1,deadline);
        else return searchRecursive(arr,mid+1,h,deadline);
    }
    public static void main(String[] args) {
        int[] arr={3,6,7,15};
        System.out.println(search(arr,arr.length,8));
        System.out.println(searchRecursive(arr,0,arr.length-1,8));
    }
}
