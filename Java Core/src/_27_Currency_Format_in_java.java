import java.util.*;
import java.text.NumberFormat;
public class _27_Currency_Format_in_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount in double or float"); //ex:1234.123
        double payment = scanner.nextDouble();
        scanner.close();
        //here get currency instance **Keyword is used to covert the us,china and france currencies but it not applicable for india so we create an constructor of own for that
        NumberFormat usFormat=NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat cnFormat=NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat frFormat=NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat inFormat=NumberFormat.getCurrencyInstance(new Locale("en","in"));

        String us=usFormat.format(payment);
        String india=inFormat.format(payment);
        String france=frFormat.format(payment);
        String china=cnFormat.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
