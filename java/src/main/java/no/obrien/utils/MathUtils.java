package no.obrien.utils;

import java.math.BigInteger;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MathUtils {

  /**
   * Finds the Least Common Multiple (LCM) of a list of numbers.
   *
   * @param numbers the list of numbers
   * @return the LCM of the numbers
   */
  public static BigInteger findLCM(List<Integer> numbers) {
    BigInteger result = BigInteger.valueOf(numbers.get(0));

    for (int i = 1; i < numbers.size(); i++) {
      BigInteger currentNumber = BigInteger.valueOf(numbers.get(i));
      result = lcm(result, currentNumber);
    }

    return result;
  }

  /**
   * Finds the Greatest Common Divisor (GCD) of a list of numbers.
   *
   * @param a the first number
   * @param b the second number
   * @return the GCD of the numbers
   */
  private static BigInteger gcd(BigInteger a, BigInteger b) {
    return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
  }

  /**
   * Finds the Least Common Multiple (LCM) of two numbers.
   *
   * @param a the first number
   * @param b the second number
   * @return the LCM of the numbers
   */
  private static BigInteger lcm(BigInteger a, BigInteger b) {
    return a.multiply(b).divide(gcd(a, b));
  }
}
