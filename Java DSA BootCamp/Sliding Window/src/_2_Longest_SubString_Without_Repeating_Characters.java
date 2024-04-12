import java.util.HashMap;

public class _2_Longest_SubString_Without_Repeating_Characters {
    public static int subString(String s){
        int count=0,l=0,r;
        HashMap<Character,Integer> memory=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(memory.containsKey(s.charAt(i))) l=Math.max(l,memory.get(s.charAt(i))+1);
            memory.put(s.charAt(i),i);
            r=i+1;
            count=Math.max(count,r-l);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(subString("SadiqMohammad"));
    }
}
