package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalorieCountingTest {

  private static final String INPUT_FILE_PATH = "twentytwo/calorie_counting.txt";

  @Test
  void testLargestCalorieCount() {
    assertEquals(
        69626,
        CalorieCounting.CalculateCalorieCounts(1, INPUT_FILE_PATH));
  }

  @Test
  void testTopThreeSum() {
    assertEquals(
        206780,
        CalorieCounting.CalculateCalorieCounts(3, INPUT_FILE_PATH));
  }
}