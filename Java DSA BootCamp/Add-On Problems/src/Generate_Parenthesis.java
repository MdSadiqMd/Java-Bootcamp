import java.util.*;

class Generate_Parenthesis {
    public static void generateParenthesis(int n, int open, int close, String s, ArrayList<String> ans) {
        if (open == n && close == n) {
            ans.add(s);
            return;
        }
        if (open < n) {
            generateParenthesis(n, open + 1, close, s + "{",ans);
        }
        if (close < open) {
            generateParenthesis(n, open, close + 1, s + "}", ans);
        }
    }

    public static void main(String[] args)
    {
        int n = 3;
        ArrayList<String> ans = new ArrayList<>();
        // initially we are passing the counts of open and
        // close as 0, and the string s as an empty string.
        generateParenthesis(n, 0, 0, "", ans);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}

