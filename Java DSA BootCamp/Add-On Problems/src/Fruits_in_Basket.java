import java.util.HashMap;
import java.util.Map;

public class Fruits_in_Basket {
    public static int totalFruit(int[] arr){
        int left=0;
        int right=0;
        int total=0;
        Map<Integer,Integer> basket=new HashMap<>();
        for(right=0;right<arr.length;right++){
            int currentCount=basket.getOrDefault(arr[right],0);
            basket.put(arr[right],currentCount+1);
            while(basket.size()>2){
                int fruitCount=basket.get(arr[left]);
                if(fruitCount==1){
                    basket.remove(arr[left]);
                } else {
                    basket.put(arr[left],fruitCount-1);
                    left++;
                }
                total=Math.max(total,right-left+1);
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int[] arr={1,2,1,1,3,4,2,2,2,2,4};
        System.out.println(totalFruit(arr));
    }
}
