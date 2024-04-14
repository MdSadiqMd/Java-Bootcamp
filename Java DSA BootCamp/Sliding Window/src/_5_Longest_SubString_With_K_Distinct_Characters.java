import java.util.HashMap;

public class _5_Longest_SubString_With_K_Distinct_Characters {
    public static int length(String s,int k){
        int l=0,r=0,len=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(0),0)+1);
            if(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
                l++;
            }
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(length("sadiq",2));
    }
}
