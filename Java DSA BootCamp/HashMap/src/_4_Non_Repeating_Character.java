import java.util.*;

public class _4_Non_Repeating_Character {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String str = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        int result = -1;

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                result = i;
                System.out.println("First Non-Repeating Character is: " + str.charAt(i));
                break;
            }
        }

        if (result == -1) {
            System.out.println("No Character is possible");
        }
    }
}
