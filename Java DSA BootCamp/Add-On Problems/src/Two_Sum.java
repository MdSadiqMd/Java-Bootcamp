public class Two_Sum {
    public static int[] sum(int[] arr,int target){
        int[] ans=new int[2];
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={3,2,4};
        int target=6;
        int[] ans=sum(arr,target);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
