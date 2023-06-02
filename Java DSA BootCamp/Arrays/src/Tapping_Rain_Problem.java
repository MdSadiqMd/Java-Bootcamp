import java.util.*;
//Brute Force --> We take left and right maximum using Math.max Function and take the value out of it
//optimized Approach --> Compare right and left higher index values using variables --> Go for Strives video
public class Tapping_Rain_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length of the Array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        int res = 0;
        int maxleft = 0;
        int maxright = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= maxleft)
                    maxleft = arr[left];
                else
                    res += maxleft - arr[left];

                left++;
            } else {
                if (arr[right] >= maxright)
                    maxright = arr[right];
                else
                    res += maxright - arr[right];

                right--;
            }
        }

        System.out.println("Result: " + res);
    }
}
