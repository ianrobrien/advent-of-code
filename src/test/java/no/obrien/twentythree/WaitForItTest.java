package no.obrien.twentythree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class WaitForItTest {

  private static final String INPUT_FILE_PATH = "twentythree/waitforit.txt";

  @Test
  void testPartOne() {
    assertEquals(
        505494,
        WaitForIt.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        23632299L,
        WaitForIt.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }
}
