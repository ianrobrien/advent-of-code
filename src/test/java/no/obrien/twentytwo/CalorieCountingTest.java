package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.twentytwo.day01.CalorieCounting;
import org.junit.jupiter.api.Test;

class CalorieCountingTest {

  private static final String INPUT_FILE_PATH = "twentytwo/calorie_counting.txt";

  @Test
  void testPartOne() {
    assertEquals(
        69626,
        CalorieCounting.partOne(INPUT_FILE_PATH));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        206780,
        CalorieCounting.partTwo(INPUT_FILE_PATH));
  }
}