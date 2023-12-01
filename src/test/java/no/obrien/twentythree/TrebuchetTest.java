package no.obrien.twentythree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrebuchetTest {

  private static final String INPUT_FILE_PATH = "twentythree/trebuchet.txt";

  @Test
  void testPartOne() {
    assertEquals(
        55386,
        Trebuchet.partOne(INPUT_FILE_PATH));
  }
}