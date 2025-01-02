package no.obrien.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

  @Test
  public void testFindLCM() {
    List<Integer> numbers1 = Arrays.asList(4, 6, 8, 10);
    assertEquals(BigInteger.valueOf(120), MathUtils.findLCM(numbers1));

    List<Integer> numbers2 = Arrays.asList(5, 7, 11);
    assertEquals(BigInteger.valueOf(385), MathUtils.findLCM(numbers2));

    List<Integer> numbers3 = Arrays.asList(15, 25, 35);
    assertEquals(BigInteger.valueOf(525), MathUtils.findLCM(numbers3));

    List<Integer> numbers4 = Arrays.asList(17, 23, 31);
    // LCM of mutually prime numbers is their product
    assertEquals(BigInteger.valueOf(17 * 23 * 31), MathUtils.findLCM(numbers4));
  }
}