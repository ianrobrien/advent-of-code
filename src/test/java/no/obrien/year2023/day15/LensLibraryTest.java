package no.obrien.year2023.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class LensLibraryTest {

  private static final String INPUT_FILE_PATH = "year2023/day15/LensLibrary.txt";

  @Test
  void testPartOne() {
    assertEquals(
        515210,
        LensLibrary.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        0,
        LensLibrary.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartOneSample() {
    var input = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
    assertEquals(0, LensLibrary.partOne(input.lines().toList()));
  }

  @Test
  void testPartTwoSample() {
    var input = """
        """;
    assertEquals(0, LensLibrary.partTwo(input.lines().toList()));
  }
}
