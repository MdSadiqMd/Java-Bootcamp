import java.text.DecimalFormat;
/*
The code line you provided is in Java and is creating an instance of the `DecimalFormat` class with a specific format pattern. The format pattern used in this case is `"'$'###,##0.00"`. Let's break it down:

- `DecimalFormat` is a class in Java that is used for formatting decimal numbers according to a specified pattern.
- `CurrencyFormat` is the name of the variable that holds the instance of the `DecimalFormat` class.
- `new DecimalFormat("'$'###,##0.00")` creates a new instance of the `DecimalFormat` class with the format pattern specified as `"'$'###,##0.00"`.

Now, let's understand the format pattern itself:

- `'$'` is a literal dollar sign ('$') that will be used as the currency symbol in the formatted output.
- `###,##0.00` is the pattern for formatting the actual numeric value. Here's how it breaks down:
  - `###` specifies that there can be any number of digits before the decimal point.
  - `##0.00` specifies that there can be two digits after the decimal point. The '0' indicates that if there are no digits, a '0' will be displayed.

So, the `CurrencyFormat` instance created with the format pattern `"'$'###,##0.00"` will format decimal numbers as currency values, with a dollar sign ('$') as the currency symbol, comma-separated thousands, and two decimal places. For example, if you use this formatter to format the number 12345.6789, the output will be "$12,345.68".

This code line is useful when you want to format decimal numbers as currency values according to a specific pattern.
 */
public class _65_Decimal_Format {
    public static void main(String[] args) {
        // Create a DecimalFormat instance with the desired format pattern
        DecimalFormat currencyFormat = new DecimalFormat("'$'###,##0.00");
        double number = 12345.6789;
        String formattedNumber = currencyFormat.format(number);
        System.out.println("Formatted Number: " + formattedNumber);
    }
}
