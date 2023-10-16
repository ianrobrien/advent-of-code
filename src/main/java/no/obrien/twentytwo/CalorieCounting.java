package no.obrien.twentytwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import no.obrien.utils.FileUtils;

@UtilityClass
@Slf4j
public class CalorieCounting {

  public int partOne(String filePath) {
    return CalculateCalorieCounts(1, FileUtils.parseInputFile(filePath));
  }

  public int partTwo(String filePath) {
    return CalculateCalorieCounts(3, FileUtils.parseInputFile(filePath));
  }

  private int CalculateCalorieCounts(int numberOfElves, List<String> filePath) {
    var calorieCounts = groupCalorieCounts(filePath);
    calorieCounts.sort(Collections.reverseOrder());
    return calorieCounts.stream()
        .limit(numberOfElves)
        .mapToInt(Integer::intValue)
        .sum();
  }

  private List<Integer> groupCalorieCounts(List<String> filePath) {
    var calories = new ArrayList<Integer>();
    final AtomicInteger caloriesCount = new AtomicInteger();
    filePath.forEach(line -> {
      if (line.isBlank()) {
        calories.add(caloriesCount.get());
        caloriesCount.set(0);
      } else {
        caloriesCount.set(caloriesCount.get() + Integer.parseInt(line));
      }
    });

    return calories;
  }
}
