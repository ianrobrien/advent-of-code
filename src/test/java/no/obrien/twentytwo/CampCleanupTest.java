package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CampCleanupTest {

  @Test
  void testPartOne() {
    assertEquals(567, CampCleanup.partOne());
  }

  @Test
  void testPartTwo() {
    assertEquals(907, CampCleanup.partTwo());
  }
}