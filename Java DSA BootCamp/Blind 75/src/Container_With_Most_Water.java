public class Container_With_Most_Water {
    public static int maxArea(int[] arr) { // go to basics area = width * height do it
        int left=0,right=arr.length-1,ans=0;
        while(left<right){
            ans=Math.max(ans,Math.min(arr[left],arr[right])*(right-left));
            if(arr[left]<arr[right]) left++;
            else right--;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
