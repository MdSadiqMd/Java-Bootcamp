import java.util.ArrayList;
import java.util.Arrays;
/*
for explanation see GFG Website
 */
public class _2_Generate_All_Possible_SubSequences {
    public static void PrintSequences(int[] arr, int index, ArrayList<Integer> temparr){
        if(index==arr.length){
            if(temparr.size()>0){
                System.out.println(temparr);
            }
            return;
        }
        //Recursive Call

        //Include Elements
        PrintSequences(arr,index+1,temparr);
        //Add Value to temp arr
        temparr.add(arr[index]);
        //Do not Include Index
        PrintSequences(arr,index+1,temparr);
        //Remove the value of temp arr
        temparr.remove(temparr.size()-1);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        PrintSequences(arr,0,new ArrayList<Integer>());
    }
}
