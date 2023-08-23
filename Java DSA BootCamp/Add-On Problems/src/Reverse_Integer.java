public class Reverse_Integer {
    public static int reverse(int x) {
        StringBuilder a = new StringBuilder(Integer.toString(Math.abs(x)));
        int i = 0;
        int j = a.length() - 1;

        while (i < j) {
            char temp = a.charAt(i);
            a.setCharAt(i, a.charAt(j));
            a.setCharAt(j, temp);
            i++;
            j--;
        }

        try {
            int reversed = Integer.parseInt(a.toString());
            return x < 0 ? -reversed : reversed;
        } catch (NumberFormatException e) {
            return 0; // Handle the case where the reversed value exceeds integer limits
        }
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println(reverse(x));
    }
}
