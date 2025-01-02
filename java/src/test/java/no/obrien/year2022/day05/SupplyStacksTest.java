package no.obrien.year2022.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SupplyStacksTest {

  private static final String INPUT_FILE_PATH = "year2022/day05/supply_stacks.txt";

  @Test
  void testPartOne() {
    assertEquals("TBVFVDZPN", SupplyStacks.partOne(INPUT_FILE_PATH));
  }

  @Test
  void testPartTwo() {
    assertEquals("VLCWHTDSZ", SupplyStacks.partTwo(INPUT_FILE_PATH));
  }
}