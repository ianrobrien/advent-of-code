package no.obrien.year2023.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class GearRatiosTest {

  private static final String INPUT_FILE_PATH = "year2023/day03/gearratios.txt";

  @Test
  void testPartOne() {
    assertEquals(
        539713,
        GearRatios.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartOneSample() {
    assertEquals(4361,
        GearRatios.partOne(List.of(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598..")));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        84159075,
        GearRatios.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartTwoSample() {
    assertEquals(467835,
        GearRatios.partTwo(List.of(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598..")));
  }

  @Test
  void testLookLeft() {
    assertEquals(
        0,
        GearRatios.partOne(List.of(
            "123")));
    assertEquals(
        0,
        GearRatios.partOne(List.of(
            ".123")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "*123")));
    assertEquals(
        0,
        GearRatios.partOne(List.of(
            "123.")));
    assertEquals(
        0,
        GearRatios.partOne(List.of(
            ".123.")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "*123.")));
  }

  @Test
  void testLookRight() {
    assertEquals(
        0,
        GearRatios.partOne(List.of(
            "123")));
    assertEquals(
        0,
        GearRatios.partOne(List.of(
            "123.")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "123*")));
    assertEquals(
        0,
        GearRatios.partOne(List.of(
            ".123")));
    assertEquals(
        0,
        GearRatios.partOne(List.of(
            ".123.")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            ".123*")));
  }

  @Test
  void testLookUp() {
    assertEquals(
        0,
        GearRatios.partOne(List.of(
            "...",
            "123")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "#..",
            "123")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            ".#.",
            "123")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "..#",
            "123")));

    assertEquals(
        0,
        GearRatios.partOne(List.of(
            "....",
            ".123")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "#...",
            ".123")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            ".#..",
            ".123")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "..#.",
            ".123")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "...#",
            ".123")));

    assertEquals(
        0,
        GearRatios.partOne(List.of(
            ".....",
            ".123.")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "#....",
            ".123.")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            ".#...",
            ".123.")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "..#..",
            ".123.")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "...#.",
            ".123.")));
    assertEquals(
        123,
        GearRatios.partOne(List.of(
            "....#",
            ".123.")));

    assertEquals(
        0,
        GearRatios.partOne(List.of(
            "....",
            "123.")));
  }

  @Test
  void partTwoLookLeftAndRight() {
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "123#456")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            ".123#456")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "123#456.")));
  }

  @Test
  void partTwoLookUp() {
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "123....",
            "#456...")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "123....",
            ".#456..")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "123....",
            "..#456.")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "123....",
            "...#456")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            ".123....",
            "...#456.")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "123....",
            "456#...")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            ".123...",
            "456#...")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "..123..",
            "456#...")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "...123.",
            "456#...")));
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "....123",
            "456#...")));
  }


  @Test
  void partTwoLookDown() {
    assertEquals(
        56088,
        GearRatios.partTwo(List.of(
            "123#....",
            "....456.")));
  }
}
