import java.util.HashMap;
import java.util.Map;
/*
This Problem will change with some words itself like
Inplace of Array it may be string to find the substring with distinct words
or a value k is given and asked to find the kth number of substrings
 */
public class Fruits_in_Basket {
    public static int totalFruit(int[] arr) {
        int left = 0;
        int right = 0;
        int total = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        for (right = 0; right < arr.length; right++) {
            // Check if the key exists in the map
            if (basket.containsKey(arr[right])) {
                int currentCount = basket.get(arr[right]);
                basket.put(arr[right], currentCount + 1);
            } else {
                basket.put(arr[right], 1); // Initialize count to 1 if the key is not present
            }

            while (basket.size() > 2) {
                // Check if the key exists in the map before accessing it
                if (basket.containsKey(arr[left])) {
                    int fruitCount = basket.get(arr[left]);
                    if (fruitCount == 1) {
                        basket.remove(arr[left]);
                    } else {
                        basket.put(arr[left], fruitCount - 1);
                    }
                    left++;
                }
                total = Math.max(total, right - left + 1);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 4, 2, 2, 2, 2, 4};
        System.out.println(totalFruit(arr));
    }
}
