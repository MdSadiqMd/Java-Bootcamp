//For Sorting Based on Values just replace the line put to data.put(b,a) do tree map take values as key and sort it
//To Find the Largest Key sort the elements in tree map and return the last key using map.lastEntry() method
import java.util.Scanner;
import java.util.TreeMap;

public class _7_Sorting_Key_in_HashMap {
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
