public class _7_Longest_Repeating_Characters_With_Replacement {
    public static int count(String s,int k){
        int l=0,r=0,len=0,count=0;
        int[] memo=new int[128];
        while(r<s.length()){
            char right=s.charAt(r);
            memo[right-'A']++;
            count=Math.max(count,memo[right-'A']);
            int window=r-l+1;
            if(window-count>k){
                char left=s.charAt(l);
                memo[left-'A']--;
                l++;
            }
            r++;
            len=Math.max(len,r-l);
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(count("Sadiq",2));
    }
}
