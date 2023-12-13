package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.twentytwo.day04.CampCleanup;
import org.junit.jupiter.api.Test;

class CampCleanupTest {

  private static final String INPUT_FILE_PATH = "twentytwo/camp_cleanup.txt";

  @Test
  void testPartOne() {
    assertEquals(567, CampCleanup.partOne(INPUT_FILE_PATH));
  }

  @Test
  void testPartTwo() {
    assertEquals(907, CampCleanup.partTwo(INPUT_FILE_PATH));
  }
}