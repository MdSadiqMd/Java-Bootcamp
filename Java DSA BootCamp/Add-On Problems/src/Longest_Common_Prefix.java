public class Longest_Common_Prefix {
    public static StringBuilder commonPrefix(String[] s) {
        StringBuilder ans = new StringBuilder();
        if(s!=null){
            for (int i = 0; i <s.length-1; i++) {
                char currentChar = s[0].charAt(i);
                for (int j = 1; j < s.length; j++) {
                    if (s[j].charAt(i) == currentChar) {
                        ans.append(currentChar);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s = { "flower", "flow", "sight" };
        System.out.println(commonPrefix(s));
    }
}
