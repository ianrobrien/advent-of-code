package no.obrien.year2022.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CathodeRayTubeTest {

  private static final String INPUT_FILE_PATH = "year2022/day10/cathode_ray_tube.txt";

  @Test
  void testPartOne() {
    assertEquals(14620, CathodeRayTube.partOne(INPUT_FILE_PATH));
  }

  @Test
    /*
     * ###....##.####.###..#..#.###..####.#..#.
     * #..#....#.#....#..#.#..#.#..#.#....#..#.
     * ###.....#.###..#..#.####.#..#.###..#..#.
     * #..#....#.#....###..#..#.###..#....#..#.
     * #..#.#..#.#....#.#..#..#.#.#..#....#..#.
     * ###...##..#....#..#.#..#.#..#.#.....##..
     */
  void testPartTwo() {
    assertEquals(
        "###....##.####.###..#..#.###..####.#..#." +
            "#..#....#.#....#..#.#..#.#..#.#....#..#." +
            "###.....#.###..#..#.####.#..#.###..#..#." +
            "#..#....#.#....###..#..#.###..#....#..#." +
            "#..#.#..#.#....#.#..#..#.#.#..#....#..#." +
            "###...##..#....#..#.#..#.#..#.#.....##.."
        , CathodeRayTube.partTwo(INPUT_FILE_PATH));
  }
}
