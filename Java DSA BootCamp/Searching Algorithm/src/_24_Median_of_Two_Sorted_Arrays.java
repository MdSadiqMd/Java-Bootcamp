public class _24_Median_of_Two_Sorted_Arrays {
    // Median of Two Sorted Arrays with Different Sizes --> https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
    public static int median(int[] a,int[] b){
        int n1 = a.length, n2 = b.length;
        if (n1 > n2) return median(b, a);
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return (int)((Math.max(l1, l2) + Math.min(r1, r2))/ 2.0);
            }
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }
    public static int medianRecursive(int[] a,int[] b,int low,int high){
        int n1 = a.length, n2 = b.length;
        if (n1 > n2) return median(b, a);
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;
        if(low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return (int)((Math.max(l1, l2) + Math.min(r1, r2))/ 2.0);
            }
            else if (l1 > r2) return medianRecursive(a,b,low,mid1-1);
            else return medianRecursive(a,b,mid1+1,high);
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] a={1,4,7,10,12};
        int[] b={2,3,6,15};
        System.out.println(median(a,b));
        System.out.println(medianRecursive(a,b,0,a.length));
    }
}
