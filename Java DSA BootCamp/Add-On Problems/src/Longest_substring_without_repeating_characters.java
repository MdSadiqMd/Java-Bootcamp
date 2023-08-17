public class Longest_substring_without_repeating_characters {
    public static int count(String s) {
        int maxLength = 0;
        int n = s.length();
        int[] charIndex = new int[128]; // Assuming ASCII character set

        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(i, charIndex[s.charAt(j)]);

            maxLength = Math.max(maxLength, j - i + 1);
            charIndex[s.charAt(j)] = j + 1;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = count(s);
        System.out.println(result); // Output: 3 (The longest substring without repeating characters is "abc")
    }
}
