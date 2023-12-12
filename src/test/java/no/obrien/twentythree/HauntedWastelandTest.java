package no.obrien.twentythree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class HauntedWastelandTest {

  private static final String INPUT_FILE_PATH = "twentythree/hauntedwasteland.txt";

  @Test
  void testPartOne() {
    assertEquals(
        16697,
        HauntedWasteland.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

//  @Test
//  void testPartTwo() {
//    assertEquals(
//        77021,
//        HauntedWasteland.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
//  }
}
