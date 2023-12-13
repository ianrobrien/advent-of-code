package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.twentytwo.day03.RucksackReorganization;
import org.junit.jupiter.api.Test;

class RucksackReorganizationTest {

  private static final String INPUT_FILE_PATH = "twentytwo/rucksack_reorganization.txt";

  @Test
  void testPartOne() {
    assertEquals(
        7811,
        RucksackReorganization.partOne(INPUT_FILE_PATH));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        2639,
        RucksackReorganization.partTwo(INPUT_FILE_PATH));
  }
}