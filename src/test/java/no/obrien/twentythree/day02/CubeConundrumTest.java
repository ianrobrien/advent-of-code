package no.obrien.twentythree.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class CubeConundrumTest {

  private static final String INPUT_FILE_PATH = "twentythree/cubeconundrum.txt";

  @Test
  void testPartOne() {
    assertEquals(
        2285,
        CubeConundrum.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        77021,
        CubeConundrum.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }
}
