package no.obrien.twentytwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreetopTreeHouseTest {

  private static final String INPUT_FILE_PATH = "twentytwo/treetop_tree_house.txt";

  @Test
  void testPartOne() {
    assertEquals(0, TreetopTreeHouse.partOne(INPUT_FILE_PATH));
  }
}