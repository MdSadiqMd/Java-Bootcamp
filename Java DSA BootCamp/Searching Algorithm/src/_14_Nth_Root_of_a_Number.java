public class _14_Nth_Root_of_a_Number {
    // Nth Root of a Number --> https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
    // The Cube will easily Overflow. So, we write the helper function to return the condition
    public static int helper(int mid,int n,int m){
        long ans=1;
        for(int i=0;i<n;i++){
            ans=ans*mid;
            if(ans>m) return 2;
        }
        if(ans==0) return 1;
        else return 0;
    }
    public static int search(int n){
        int l=1,h=n;
        while(l<=h){
            int mid=l+(h-l)/2;
            int val=helper(mid,n,3);
            if(val==1) return mid;
            if(val==0) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(search(27));
    }
}
