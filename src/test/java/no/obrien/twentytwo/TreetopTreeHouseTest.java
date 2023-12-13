package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.twentytwo.day08.TreetopTreeHouse;
import org.junit.jupiter.api.Test;

class TreetopTreeHouseTest {

  private static final String INPUT_FILE_PATH = "twentytwo/treetop_tree_house/";

  @Test
  void testPartOne() {
    assertEquals(1715, TreetopTreeHouse.partOne(INPUT_FILE_PATH + "treetop_tree_house.txt"));
  }

  @Test
  void testPartSample() {
    assertEquals(21, TreetopTreeHouse.partOne(INPUT_FILE_PATH + "treetop_tree_house_sample.txt"));
  }

  @Test
  void testPartUp() {
    assertEquals(9, TreetopTreeHouse.partOne(INPUT_FILE_PATH + "treetop_tree_house_up.txt"));
  }

  @Test
  void testPartDown() {
    assertEquals(9, TreetopTreeHouse.partOne(INPUT_FILE_PATH + "treetop_tree_house_down.txt"));
  }

  @Test
  void testPartLeft() {
    assertEquals(9, TreetopTreeHouse.partOne(INPUT_FILE_PATH + "treetop_tree_house_left.txt"));
  }

  @Test
  void testPartRight() {
    assertEquals(9, TreetopTreeHouse.partOne(INPUT_FILE_PATH + "treetop_tree_house_right.txt"));
  }

  @Test
  void testPartTwoSample() {
    assertEquals(8, TreetopTreeHouse.partTwo(INPUT_FILE_PATH + "treetop_tree_house_sample.txt"));
  }

  @Test
  void testPartTwo() {
    assertEquals(374400, TreetopTreeHouse.partTwo(INPUT_FILE_PATH + "treetop_tree_house.txt"));
  }
}