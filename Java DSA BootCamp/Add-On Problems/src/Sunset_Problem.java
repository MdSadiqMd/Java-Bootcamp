import java.util.Scanner;

// you are give n an postive integer array arr of size n as its arguments, there are n buildings and print the count of all buildings that will see the sunset
// return -1 if rr is null
// example input:
// 10
// 4 3 5 6 4 7 6 8 3 9
// output: 6
// as the buildings that can see are 4, 5, 6, 7, 8 , 9

public class Sunset_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] parts = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(countSunsetBuildings(arr));
    }

    public static int countSunsetBuildings(int[] arr) {
        if (arr == null) {
            return -1;
        }
        if (arr.length == 0) {
            return -1;
        }
        int maxHeight = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxHeight) {
                count++;
                maxHeight = arr[i];
            }
        }
        return count;
    }
}
