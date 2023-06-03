import java.math.BigInteger;
import java.util.Scanner;
// Here we divide the problem into two half
//Even power = 2^64 = 2^32 * 2^32
//Odd Power = 2^65 = 2 * 2^32 * 2^32
//Here we use BigInteger to Re-Solve Future problems
public class _4_Finding_Power_Using_Recursion_Optimized {
    public static BigInteger power(BigInteger n, BigInteger m) {
        if (m.equals(BigInteger.ZERO)) { // Base Condition
            return BigInteger.ONE;
        } else if (m.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            BigInteger result = power(n, m.divide(BigInteger.TWO));
            return result.multiply(result);
        } else {
            BigInteger result = power(n, (m.subtract(BigInteger.ONE)).divide(BigInteger.TWO));
            return n.multiply(result.multiply(result));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        BigInteger n = sc.nextBigInteger();

        System.out.println("Enter the Power:");
        BigInteger m = sc.nextBigInteger();

        System.out.println("The Answer is " + power(n, m));
    }
}