package no.obrien.twentythree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class TrebuchetTest {

  private static final String INPUT_FILE_PATH = "twentythree/trebuchet.txt";

  @Test
  void testPartOne() {
    assertEquals(
        55386,
        Trebuchet.partOne(INPUT_FILE_PATH));
  }


  @Test
  void testPartTwo() {
    assertEquals(
        54824,
        Trebuchet.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testJustNumbers() {
    assertEquals(
        11,
        Trebuchet.partTwo(List.of("1")));
    assertEquals(
        11,
        Trebuchet.partTwo(List.of("11")));
  }

  @Test
  void testJustWords() {
    assertEquals(
        11,
        Trebuchet.partTwo(List.of("one")));
    assertEquals(
        11,
        Trebuchet.partTwo(List.of("one2one")));
  }
}
