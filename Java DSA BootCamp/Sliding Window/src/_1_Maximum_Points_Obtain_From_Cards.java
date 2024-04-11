public class _1_Maximum_Points_Obtain_From_Cards {
    public static int sum(int[] arr,int k){
        int lSum=0,rSum=0,sum;
        for(int i=0;i<=k-1;i++) lSum=lSum+arr[i];
        sum=lSum;
        int rIndex=arr.length-1;
        for(int i=k-1;i>=0;i--){
            lSum=lSum-arr[i];
            rSum=rSum+arr[rIndex];
            rIndex=rIndex-1;
            sum=Math.max(sum,lSum+rSum);
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sum(new int[]{6,2,3,4,7,2,1,7,1},4));
    }
}
