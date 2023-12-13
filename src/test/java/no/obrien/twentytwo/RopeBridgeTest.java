package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import no.obrien.twentytwo.day09.RopeBridge;
import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class RopeBridgeTest {

  private static final String INPUT_FILE_PATH = "twentytwo/rope_bridge/";

  @Test
  void testSample() {
    assertEquals(
        13,
        RopeBridge.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH + "rope_bridge_sample.txt")));
  }

  @Test
  void testPartOne() {
    assertEquals(
        6011,
        RopeBridge.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH + "rope_bridge.txt")));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        2419,
        RopeBridge.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH + "rope_bridge.txt")));
  }

  @Test
  void testPartTwoSimple() {
    assertEquals(
        1,
        RopeBridge.partTwo(List.of("R 4", "U 4")));
  }

  @Test
  void testStartPosition() {
    assertEquals(1, RopeBridge.partOne(List.of("")));
  }

  @Test
  void testMoveUp() {
    assertEquals(1, RopeBridge.partOne(List.of("U 1")));

    assertEquals(2, RopeBridge.partOne(List.of("U 2")));

    assertEquals(3, RopeBridge.partOne(List.of("U 3")));

    var directions = List.of("R 1", "U 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("R 1", "U 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("R 1", "U 1", "D 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("R 1", "U 1", "D 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("R 1", "D 1", "U 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("R 1", "D 1", "U 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "U 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "U 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("L 1", "U 1", "D 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "U 1", "D 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "D 1", "U 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "D 1", "U 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("U 2", "D 1");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("U 2", "D 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("U 2", "D 3");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("U 2", "D 4");
    assertEquals(3, RopeBridge.partOne(directions));
  }

  @Test
  void testMoveDown() {
    assertEquals(1, RopeBridge.partOne(List.of("D 1")));

    assertEquals(2, RopeBridge.partOne(List.of("D 2")));

    assertEquals(3, RopeBridge.partOne(List.of("D 3")));

    var directions = List.of("R 1", "D 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("R 1", "D 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("R 1", "D 1", "U 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("R 1", "D 1", "U 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("R 1", "U 1", "D 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("R 1", "U 1", "D 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "D 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "D 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("L 1", "D 1", "U 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "D 1", "U 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "U 1", "D 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 1", "U 1", "D 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 2", "U 1");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("D 2", "U 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("D 2", "U 3");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("D 2", "U 4");
    assertEquals(3, RopeBridge.partOne(directions));
  }

  @Test
  void testMoveLeft() {
    assertEquals(1, RopeBridge.partOne(List.of("L 1")));

    assertEquals(2, RopeBridge.partOne(List.of("L 2")));

    assertEquals(3, RopeBridge.partOne(List.of("L 3")));

    var directions = List.of("U 1", "L 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("U 1", "L 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("U 1", "R 1", "L 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("U 1", "R 1", "L 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("U 1", "L 1", "R 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("U 1", "L 1", "R 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "L 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "L 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("D 1", "R 1", "L 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "R 1", "L 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "L 1", "R 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "L 1", "R 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("L 2", "R 1");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("L 2", "R 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("L 2", "R 3");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("L 2", "R 4");
    assertEquals(3, RopeBridge.partOne(directions));
  }

  @Test
  void testMoveRight() {
    assertEquals(1, RopeBridge.partOne(List.of("R 1")));

    assertEquals(2, RopeBridge.partOne(List.of("R 2")));

    assertEquals(3, RopeBridge.partOne(List.of("R 3")));

    var directions = List.of("U 1", "R 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("U 1", "R 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("U 1", "L 1", "R 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("U 1", "L 1", "R 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("U 1", "R 1", "L 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("U 1", "R 1", "L 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "R 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "R 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("D 1", "L 1", "R 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "L 1", "R 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "R 1", "L 1");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("D 1", "R 1", "L 2");
    assertEquals(1, RopeBridge.partOne(directions));

    directions = List.of("R 2", "L 1");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("R 2", "L 2");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("R 2", "L 3");
    assertEquals(2, RopeBridge.partOne(directions));

    directions = List.of("R 2", "L 4");
    assertEquals(3, RopeBridge.partOne(directions));
  }
}