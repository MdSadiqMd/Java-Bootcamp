import java.util.Scanner;
import java.util.TreeMap;

public class _7_Sorting_Values_in_HashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, String> data = new TreeMap<>();
        int n = 4;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            String b=sc.nextLine();
            data.put(a, b);
        }
        System.out.println(data);
    }
}
