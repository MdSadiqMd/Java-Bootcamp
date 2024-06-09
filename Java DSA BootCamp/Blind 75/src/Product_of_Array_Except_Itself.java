import java.util.Arrays;

public class Product_of_Array_Except_Itself {
    // Using Division Operator
    // Think of more test cases is the example test case only given one zero then check for multiple zeroes scenario
    public static int[] productExceptSelf(int[] nums) { // TN:O(n),SC:O(1)
        int count_zero=0,product_without_zero=1;
        int[] result=new int[nums.length];
        for(int ele:nums){
            if(ele==0) count_zero++;
            else product_without_zero*=ele;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(count_zero>0) result[i]=0;
                else result[i]=product_without_zero/nums[i];
            } else {
                if(count_zero>1) result[i]=0;
                else result[i]=product_without_zero;
            }
        }
        return result;
    }
    // Without Using Division Operator
    // Think also about right and left Product
    public static int[] productExceptSelfWithoutDivisionOperator(int[] nums) { // TN:O(n),SC:O(1)
        int[] result=new int[nums.length];
        result[0]=1;
        for(int i=1;i<nums.length;i++) result[i]=result[i-1]*nums[i-1];
        int right_product=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i]*=right_product;
            right_product*=nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr={-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
        System.out.println(Arrays.toString(productExceptSelfWithoutDivisionOperator(arr)));
    }
}
