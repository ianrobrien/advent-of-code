package no.obrien.year2023.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

public class MirageMaintenanceTest {

  private static final String INPUT_FILE_PATH = "year2023/day09/miragemaintenance.txt";

  @Test
  void testPartOne() {
    assertEquals(
        1987402313,
        MirageMaintenance.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartOneSample() {
    var input = """
        0 3 6 9 12 15
        1 3 6 10 15 21
        10 13 16 21 30 45""";
    assertEquals(
        114,
        MirageMaintenance.partOne(input.lines().toList()));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        900,
        MirageMaintenance.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartTwoSample() {
    var input = """
        0 3 6 9 12 15
        1 3 6 10 15 21
        10 13 16 21 30 45""";
    assertEquals(
        2,
        MirageMaintenance.partTwo(input.lines().toList()));
  }
}
