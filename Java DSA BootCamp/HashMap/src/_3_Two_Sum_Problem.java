import java.util.*;

public class _3_Two_Sum_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Elements:");
        int n = sc.nextInt();
        System.out.println("Enter the Elements:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the Target:");
        int target = sc.nextInt();
        HashMap<Integer, Integer> Map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Map.put(arr[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            if (Map.containsKey(target - arr[i])) {
                if (Map.get(target - arr[i]) > i) {
                    result[0] = i;
                    result[1] = Map.get(target - arr[i]);
                    break;
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
