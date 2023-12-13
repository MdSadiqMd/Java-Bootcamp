/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 */
public class Regular_Expression_Matching {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // Match the first characters if p length is less than 1
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // Match the remaining characters if length is greater than 2
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
    public static void main(String[] args) {
        String s = "aa";
        String p = "a.";
        System.out.println(isMatch(s, p));
    }
}
