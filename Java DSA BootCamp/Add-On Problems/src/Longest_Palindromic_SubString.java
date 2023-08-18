public class Longest_Palindromic_SubString {
    public static String Palindrome(String s) {
        if (s.length() < 1) {
            return s;
        }
        String ans = "";

        // For Odd length Sequence
        for (int i = 0; i < s.length(); i++) {
            int low = i;
            int high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) { // First two Pointer Movements and other two termination conditions
                low--;
                high++;
            }
            String palindrome = s.substring(low + 1, high);
            if (palindrome.length() > ans.length()) {
                ans = palindrome;
            }
        }

        // For Even length Sequence
        for (int i = 0; i < s.length() - 1; i++) {
            int low = i;
            int high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) { // First two Pointer Movements and other two termination conditions
                low--;
                high++;
            }
            String palindrome = s.substring(low + 1, high);
            if (palindrome.length() > ans.length()) {
                ans = palindrome;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "babad";
        String ans = Palindrome(s);
        System.out.println(ans);
    }
}
