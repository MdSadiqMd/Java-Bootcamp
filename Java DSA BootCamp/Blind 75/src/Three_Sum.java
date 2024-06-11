import java.util.*;

public class Three_Sum {
    // First it can be solved by using three for loops

    // Think of Hashset and make use of 13th line if statement property, and for the problems which need to answers to not be duplicate, sort them and add them into answers
    public static List<List<Integer>> triplet(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> temp=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int two=-(nums[i]+nums[j]); //(0-(nums[i]+nums[j]))
                if(temp.contains(nums[j])) {
                    List<Integer> checkDuplicate = Arrays.asList(nums[i],nums[j],two);
                    checkDuplicate.sort(null);
                    ans.add(checkDuplicate);
                }
                else temp.add(two);
            }
        }
        return new ArrayList<>(ans);
    }
    // If it's Array think of sorting it, in this case it is difficult to think but when you sort then you will see that you can use pointers to solve it, don't forget to handle single and duplicate elements
    public static List<List<Integer>> tripletOptimise(int[] nums) { // TC:O(n*logn)+O(n^2),SC:O(number of quadruplets)
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int j=i+1,k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4};
        System.out.println(triplet(arr));
        System.out.println(tripletOptimise(arr));
    }
}
