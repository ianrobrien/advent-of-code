package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TuningTroubleTest {

  private static final String INPUT_FILE_PATH = "twentytwo/tuning_trouble.txt";

  @Test
  void testPartOne() {
    assertEquals(1760, TuningTrouble.partOne(INPUT_FILE_PATH));
  }

  @Test
  void testPartTwo() {
    assertEquals(2974, TuningTrouble.partTwo(INPUT_FILE_PATH));
  }
}