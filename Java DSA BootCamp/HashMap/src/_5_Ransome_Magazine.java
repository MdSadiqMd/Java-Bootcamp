/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the
letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.
Input: ransomNote = "a", magazine = "b"
Output: false
Input: ransomNote = "aa", magazine = "ab"
Output: false

Approach :
1. All Characters should be present in Magazine as required in Ransome
2. The count should be present as required for the Answer
3. Here we keep the key value 1 and if the number is repeated then we keep the key value as 2
 */
import java.util.*;
public class _5_Ransome_Magazine {
    public static void main(String[] args) {
        String r="caa";
        String m="aca";

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<r.length();i++){
            char c=r.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }

        HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<m.length();i++){
            char c=m.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c,map1.get(c)+1);
            }
            else{
                map1.put(c,1);
            }
        }

        boolean ans=true;
        for(Map.Entry<Character,Integer> e:map1.entrySet()){
            if(!map1.containsKey(e.getKey()) || e.getValue()>map1.get(e.getKey())){
                ans=false;
                break;
            }
        }
        System.out.println(ans);
    }
}
