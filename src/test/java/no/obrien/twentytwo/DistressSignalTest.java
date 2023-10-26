package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DistressSignalTest {

  private final static String INPUT_FILE_PATH = "twentytwo/distress_signal.txt";

  @Test
  void testPartOne() {
    assertEquals(0, DistressSignal.partOne(INPUT_FILE_PATH));
  }
}