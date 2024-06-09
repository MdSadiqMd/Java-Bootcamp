import java.util.Arrays;
import java.util.HashSet;

public class Contains_Duplicate {
    // First think of can we reduce HashMap problem to HashSet rather doing multiple complications
    public static boolean containsDuplicate(int[] nums) { // TC:O(N),SC:O(N)
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<=nums.length-1;i++) {
            if(!set.add(nums[i])) return true; // If you can't able to add the Integer in set return true
        };
        return false;
    }
    // If Arrays problem is Present first think of sorting
    public static boolean containsDuplicateSort(int[] nums){ // TC:O(N*logN),SC:O(1)
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-2;i++){
            if(nums[i]==nums[i+1]) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={1,2,1,3};
        System.out.println(containsDuplicate(arr));
        System.out.println(containsDuplicateSort(arr));
    }
}
