public class _13_Sqrt_of_a_Number {
    public static int search(int n){
        int l=1,h=n,ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(mid*mid<=n){
                ans=mid;
                l=mid+1;
            }
            else h=mid-1;
        }
        return ans;
    }
    public static int searchRecursive(int n,int l,int h){
        if(l>h) return h;
        int mid=l+(h-l)/2;
        if(mid*mid<=n) return searchRecursive(n,mid+1,h);
        else return searchRecursive(n,l,mid-1);
    }
    public static void main(String[] args) {
        System.out.println(search(25));
        System.out.println(searchRecursive(25,1,25));
    }
}
