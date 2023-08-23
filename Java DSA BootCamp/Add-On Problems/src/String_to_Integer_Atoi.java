/*
Example 1:
Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.

Example 2:
Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.

Example 3:
Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 */
public class String_to_Integer_Atoi {
    public static int atoi(String s) {
        s = s.trim(); // Remove leading and trailing spaces
        if (s.isEmpty()) {
            return 0; // If the string is empty after trimming, return 0
        }

        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            start++;
        }

        long result = 0; // Use a long to handle overflow
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break; // Stop if non-digit character is encountered
            }
            result = result * 10 + (s.charAt(i) - '0'); // This line updates the result value by adding the parsed digit to it.
                                                        // Since we're dealing with digits in ASCII encoding, subtracting the ASCII value of '0' from the character gives the actual digit value.
                                                        // The multiplication by 10 shifts the existing digits to the left to make space for the new digit
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) (result * sign);
    }

    public static void main(String[] args) {
        String s = "  -42";
        int intValue = atoi(s);
        System.out.println("Converted integer value: " + intValue);
    }
}
