package no.obrien.twentytwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HillClimbingAlgorithmTest {

  private static final String INPUT_FILE_PATH = "twentytwo/hill_climbing_algorithm.txt";

  @Test
  void testPartOne() {
    assertEquals(520, new HillClimbingAlgorithm().partOne(INPUT_FILE_PATH));
  }

  @Test
  void testPartTwo() {
    assertEquals(508, new HillClimbingAlgorithm().partTwo(INPUT_FILE_PATH));
  }
}