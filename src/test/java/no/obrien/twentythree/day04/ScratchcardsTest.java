package no.obrien.twentythree.day04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.twentythree.day04.Scratchcards;
import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

public class ScratchcardsTest {

  private static final String INPUT_FILE_PATH = "twentythree/scratchcards.txt";

  @Test
  void testPartOne() {
    assertEquals(
        26218,
        Scratchcards.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        9997537,
        Scratchcards.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }
}
