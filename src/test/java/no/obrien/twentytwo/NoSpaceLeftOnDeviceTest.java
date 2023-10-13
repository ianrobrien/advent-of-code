package no.obrien.twentytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NoSpaceLeftOnDeviceTest {

  private static final String INPUT_FILE_PATH = "twentytwo/no_space_left_on_device.txt";

  @Test
  void testPartOne() {
    assertEquals(1427048, NoSpaceLeftOnDevice.partOne(INPUT_FILE_PATH));
  }

  @Test
  void testPartTwo() {
    assertEquals(2940614, NoSpaceLeftOnDevice.partTwo(INPUT_FILE_PATH));
  }
}