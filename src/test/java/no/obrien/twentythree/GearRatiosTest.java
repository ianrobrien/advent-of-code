package no.obrien.twentythree;

import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GearRatiosTest {

  private static final String INPUT_FILE_PATH = "twentythree/gearratios.txt";

  @Test
  void testPartOne() {
    assertEquals(
        539713,
        GearRatios.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

//  @Test
//  void testPartTwo() {
//    assertEquals(
//        0,
//        GearRatios.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
//  }

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
}