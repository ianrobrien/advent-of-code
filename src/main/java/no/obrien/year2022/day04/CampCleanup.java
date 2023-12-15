package no.obrien.year2022.day04;

import java.util.List;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import no.obrien.utils.FileUtils;

@UtilityClass
@Slf4j
public class CampCleanup {

  public int partOne(String inputFilePath) {
    List<String> assignments = FileUtils.parseInputFile(inputFilePath);

    int overlapCount = 0;
    for (String assignment : assignments) {
      var first = parseAssignment(assignment.split(",")[0]);
      var second = parseAssignment(assignment.split(",")[1]);

      int[] mask = new int[100];
      for (int i = 0; i < 100; i++) {
        mask[i] = first[i] & second[i];
      }

      boolean same = true;
      for (int i = 0; i < 100; i++) {
        if (first[i] != mask[i]) {
          same = false;
          break;
        }
      }
      if (same) {
        overlapCount++;
        continue;
      }

      same = true;
      for (int i = 0; i < 100; i++) {
        if (second[i] != mask[i]) {
          same = false;
          break;
        }
      }
      if (same) {
        overlapCount++;
      }
    }

    return overlapCount;
  }

  public int partTwo(String inputFilePath) {
    List<String> assignments = FileUtils.parseInputFile(inputFilePath);

    int overlapCount = 0;
    for (String assignment : assignments) {
      var first = parseAssignment(assignment.split(",")[0]);
      var second = parseAssignment(assignment.split(",")[1]);

      for (int i = 0; i < 100; i++) {
        if (first[i] == second[i] && second[i] == 1) {
          overlapCount++;
          break;
        }
      }
    }

    return overlapCount;
  }

  private int[] parseAssignment(String assignment) {
    int start = Integer.parseInt(assignment.split("-")[0]);
    int end = Integer.parseInt(assignment.split("-")[1]);
    int[] result = new int[100];

    for (int i = start; i <= end; i++) {
      result[i] = 1;
    }

    return result;
  }
}
