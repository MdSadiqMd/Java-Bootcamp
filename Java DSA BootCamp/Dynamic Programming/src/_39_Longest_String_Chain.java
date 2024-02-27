import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _39_Longest_String_Chain {
    // Longest String Chain --> https://takeuforward.org/data-structure/longest-string-chain-dp-45/
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
    static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;
        int first = 0;
        int second = 0;
        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else first++;
        }
        return first == s1.length() && second == s2.length();
    }
    static int lengthTab(List<String> arr) {
        int n = arr.size();
        arr.sort(comp);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                if (compare(arr.get(i), arr.get(prevIndex)) && 1 + dp[prevIndex] > dp[i]) dp[i] = 1 + dp[prevIndex];
            }
            if (dp[i] > maxi) maxi = dp[i];
        }
        return maxi;
    }
    public static void main(String[] args) {
        List<String> words = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");
        System.out.println(lengthTab(words));
    }
}
