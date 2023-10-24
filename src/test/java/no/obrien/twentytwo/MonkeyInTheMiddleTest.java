package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MonkeyInTheMiddleTest {

  private static final String INPUT_FILE_PATH = "twentytwo/monkey_in_the_middle.txt";

  @Test
  void testPartOne() {
    assertEquals(100345, MonkeyInTheMiddle.partOne(INPUT_FILE_PATH));
  }

  @Disabled
  @Test
  void testPartPartTwo() {
    assertEquals(100345, MonkeyInTheMiddle.partTwo(INPUT_FILE_PATH));
  }
}