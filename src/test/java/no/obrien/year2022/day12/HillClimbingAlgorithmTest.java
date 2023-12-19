package no.obrien.year2022.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HillClimbingAlgorithmTest {

  private static final String INPUT_FILE_PATH = "year2022/day12/hill_climbing_algorithm.txt";

  @Test
  void testPartOne() {
    assertEquals(520, new HillClimbingAlgorithm().partOne(INPUT_FILE_PATH));
  }

  @Test
  void testPartTwo() {
    assertEquals(508, new HillClimbingAlgorithm().partTwo(INPUT_FILE_PATH));
  }
}
