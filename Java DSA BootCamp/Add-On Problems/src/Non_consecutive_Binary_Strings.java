import java.util.Scanner;

public class Non_consecutive_Binary_Strings {
    public static int[] createBinary(int size, int[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(String.format("%3s", Integer.toBinaryString(arr[i])).replace(' ', '0'));
        }
        return arr;
    }

    public static int Count(int[] arr) {
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            String binaryStr = String.format("%03d", arr[j]);
            boolean consecutiveOnes = false;
            for (int i = 0; i < binaryStr.length() - 1; i++) {
                if (binaryStr.charAt(i) == '1' && binaryStr.charAt(i + 1) == '1') {
                    consecutiveOnes = true;
                    break;
                }
            }
            if (!consecutiveOnes) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int size = (int) Math.pow(2, a);
        int arr[] = new int[size];
        createBinary(size, arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(String.format("%03d", arr[i]));
        }
        int k = Count(arr);
        System.out.println(k);
    }
}
