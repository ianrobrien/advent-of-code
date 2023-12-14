package no.obrien.twentythree.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class ParabolicReflectorDishTest {

  private static final String INPUT_FILE = "twentythree/parabolicreflectordish.txt";

  @Test
  void testPartOne() {
    assertEquals(107430,
        ParabolicReflectorDish.partOne(FileUtils.parseInputFile(INPUT_FILE)));
  }

  @Test
  void testPartOneSample() {
    var input = """
        O....#....
        O.OO#....#
        .....##...
        OO.#O....O
        .O.....O#.
        O.#..O.#.#
        ..O..#O..O
        .......O..
        #....###..
        #OO..#....""";
    assertEquals(136,
        ParabolicReflectorDish.partOne(input.lines().collect(Collectors.toList())));
  }

  @Test
  void testPartTwo() {
    assertEquals(96317,
        ParabolicReflectorDish.partTwo(FileUtils.parseInputFile(INPUT_FILE)));
  }

  @Test
  void testPartTwoSample() {
    var input = """
        O....#....
        O.OO#....#
        .....##...
        OO.#O....O
        .O.....O#.
        O.#..O.#.#
        ..O..#O..O
        .......O..
        #....###..
        #OO..#....""";
    assertEquals(64,
        ParabolicReflectorDish.partTwo(input.lines().collect(Collectors.toList())));
  }
}