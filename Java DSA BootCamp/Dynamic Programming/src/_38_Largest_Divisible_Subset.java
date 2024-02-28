import java.util.*;

public class _38_Largest_Divisible_Subset {
    // Largest Divisible Subset --> https://takeuforward.org/data-structure/longest-divisible-subset-dp-44/

    // Recursion
    public static List<Integer> divisibleSet(int index, List<Integer> arr, List<Integer> result, List<Integer> hash, int prev) {
        if (index >= arr.size()) {
            if (hash.size() > result.size()) result = new ArrayList<>(hash);
            return result;
        }
        if (prev == -1 || arr.get(index) % prev == 0) {
            hash.add(arr.get(index));
            result = divisibleSet(index + 1, arr, result, hash, arr.get(index));
            hash.remove(hash.size() - 1);
        }
        return divisibleSet(index + 1, arr, result, hash, prev);
    }
    // Bottom - Up Approach --> Tabulation
    public static List<Integer> divisibleSetTab(List<Integer> arr,int n,List<Integer> dp,List<Integer> hash){
        for (int i = 0; i < n; i++) {
            hash.set(i, i); // Initializing with current index
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
                if (arr.get(i) % arr.get(prev_index) == 0 && 1 + dp.get(prev_index) > dp.get(i)) {
                    dp.set(i, 1 + dp.get(prev_index));
                    hash.set(i, prev_index);
                }
            }
        }
        int ans = -1;
        int lastIndex = -1;
        for (int i = 0; i < n; i++) {
            if (dp.get(i) > ans) {
                ans = dp.get(i);
                lastIndex = i;
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(arr.get(lastIndex));
        while (hash.get(lastIndex) != lastIndex) {
            lastIndex = hash.get(lastIndex);
            temp.add(arr.get(lastIndex));
        }
        Collections.reverse(temp);
        return temp;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 16, 7, 8, 4);
        int n=arr.size();
        Collections.sort(arr);
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 1));
        List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));
        int prev=-1;
        System.out.println(divisibleSet(0,arr,new ArrayList<>(),new ArrayList<>(),prev));
        System.out.println(divisibleSetTab(arr,n,result,hash));
    }
}