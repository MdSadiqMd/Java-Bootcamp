public class Palindrome_Number {
    public static boolean isPalindrome(int a) {
        String numStr = Integer.toString(a);

        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '+' || numStr.charAt(i) == '-') {
                return false;
            }
        }

        int start = 0;
        int last = numStr.length() - 1;

        while (start < last) {
            if (numStr.charAt(start) != numStr.charAt(last)) {
                return false;
            }
            start++;
            last--;
        }

        return true;
    }

    public static void main(String[] args) {
        int a = -121;
        if (isPalindrome(a)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
