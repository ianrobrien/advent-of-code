package no.obrien.year2023.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MirageMaintenance {

  public int partOne(List<String> lines) {
    var result = 0;
    for (String line : lines) {
      List<List<Integer>> histories = buildHistories(line);
      int stop = histories.size();
      for (int i = stop - 1; i >= 0; i--) {
        if (i == histories.size() - 1) {
          histories.get(i).add(0);
        } else {
          int nextRowValue = histories.get(i + 1).get(histories.get(i + 1).size() - 1);
          int currentRowLastValue = histories.get(i).get(histories.get(i).size() - 1);
          histories.get(i).add(nextRowValue + currentRowLastValue);
        }
      }
      result += histories.get(0).get(histories.get(0).size() - 1);
    }
    return result;
  }

  public int partTwo(List<String> lines) {
    var result = 0;
    for (String line : lines) {
      List<List<Integer>> histories = buildHistories(line);
      int stop = histories.size();
      for (int i = stop - 1; i >= 0; i--) {
        if (i == histories.size() - 1) {
          histories.get(i).add(0);
        } else {
          int nextRowValue = histories.get(i + 1).get(0);
          int currentRowLastValue = histories.get(i).get(0);
          histories.get(i).add(0, currentRowLastValue - nextRowValue);
        }
      }
      result += histories.get(0).get(0);
    }
    return result;
  }

  private List<List<Integer>> buildHistories(String line) {
    var history = Arrays.stream(line.split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    List<List<Integer>> histories = new ArrayList<>();
    histories.add(history);

    boolean finishedFindingDifferences = histories.get(0).stream().allMatch(n -> n == 0);
    var historyRowIndex = 0;
    while (!finishedFindingDifferences) {
      var differences = new ArrayList<Integer>();
      for (int i = 0; i < histories.get(historyRowIndex).size() - 1; i++) {
        differences.add(
            histories.get(historyRowIndex).get(i + 1) - histories.get(historyRowIndex).get(i));
      }
      histories.add(differences);
      historyRowIndex++;
      if (differences.stream().allMatch(d -> d == 0)) {
        finishedFindingDifferences = true;
      }
    }
    return histories;
  }
}
