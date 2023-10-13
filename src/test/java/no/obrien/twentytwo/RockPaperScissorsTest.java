package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RockPaperScissorsTest {

  public static final String INPUT_FILE_PATH = "twentytwo/rock_paper_scissors.txt";

  @Test
  void testRockPaperScissorsPartOne() {
    assertEquals(
        12276,
        RockPaperScissors.partOne(INPUT_FILE_PATH)
    );
  }

  @Test
  void testRockPaperScissorsPartTwo() {
    assertEquals(
        9975,
        RockPaperScissors.partTwo(INPUT_FILE_PATH)
    );
  }
}