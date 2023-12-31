package no.obrien.year2022.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RucksackReorganizationTest {

  private static final String INPUT_FILE_PATH = "year2022/day03/rucksack_reorganization.txt";

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