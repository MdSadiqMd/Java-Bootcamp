public class _6_Number_of_Substrings_Consists_K_Characters {
    public static int count(String s){
        int[] memo={-1,-1,-1};
        int count=0;
        for(int i=0;i<s.length();i++){
            memo[s.charAt(i)-'a']=i;
            if(memo[0]!=-1 && memo[1]!=-1 && memo[2]!=-1) count+=1+Math.min(memo[0],Math.min(memo[1],memo[2]));
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(count("abcabc"));
    }
}
