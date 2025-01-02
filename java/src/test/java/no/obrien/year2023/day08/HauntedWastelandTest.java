package no.obrien.year2023.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class HauntedWastelandTest {

  private static final String INPUT_FILE_PATH = "year2023/day08/hauntedwasteland.txt";

  @Test
  void testPartOne() {
    assertEquals(
        16697,
        HauntedWasteland.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        new BigInteger("10668805667831"),
        HauntedWasteland.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartTwoSample() {
    var input = """
        LR

        11A = (11B, XXX)
        11B = (XXX, 11Z)
        11Z = (11B, XXX)
        22A = (22B, XXX)
        22B = (22C, 22C)
        22C = (22Z, 22Z)
        22Z = (22B, 22B)
        XXX = (XXX, XXX)""";
    assertEquals(
        BigInteger.valueOf(6),
        HauntedWasteland.partTwo(new ArrayList<>(List.of(input.split("\\R")))));
  }
}
