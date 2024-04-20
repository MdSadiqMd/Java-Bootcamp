import java.util.HashMap;

public class _10_Minimum_Window_SubString {
    public static String subString(String s, String t) {
        int l = 0, r = 0, count = t.length(), start_i = 0, minLen = Integer.MAX_VALUE;
        if (t.length() > s.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        while (r < s.length()) {
            char ch = s.charAt(r);
            Integer value = map.get(ch);
            if (value != null) {
                map.put(ch, value - 1);
                if (value >= 1) count--;
            }
            while (count == 0) {
                int currMinLen = r - l + 1;
                if (currMinLen < minLen) {
                    minLen = currMinLen;
                    start_i = l;
                }
                char startChar = s.charAt(l);
                Integer startCharValue = map.get(startChar);
                if (startCharValue != null) {
                    map.put(startChar, startCharValue + 1);
                    if (startCharValue >= 0) count++;
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minLen);
    }
    public static void main(String[] args) {
        System.out.println(subString("adobecodecbab", "abc"));
    }
}
