public class _3_Max_Consecutive_Ones {
    public static int count(int[] arr,int k){
        int l=0,r=0,len=0,zeroes=0;
        while(r<arr.length){
            if(arr[r]==0) zeroes++;
            if(zeroes>k){
                if(arr[l]==0) zeroes--;
                l++;
            }
            if(zeroes<=k) len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(count(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }
}
