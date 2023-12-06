package no.obrien.twentythree;

import java.util.Arrays;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Scratchcards {

  public int partOne(List<String> lines) {
    int points = 0;
    for (String line : lines) {
      String[] splitByPipe = line.split("\\|");
      
      String[] winningNumbersString = splitByPipe[0].split(":")[1].trim().split("\\s+");
      String[] myNumbersString = splitByPipe[1].trim().split("\\s+");

      var winningNumbers = Arrays.stream(winningNumbersString)
          .map(Integer::parseInt)
          .toList();
      var myNumbers = Arrays.stream(myNumbersString)
          .map(Integer::parseInt)
          .toList();

      var numberOfMatchingNumbers = myNumbers.stream()
          .filter(winningNumbers::contains)
          .count();

      int tempPoints = 0;
      if (numberOfMatchingNumbers > 0) {
        tempPoints = 1;
        for (int i = 1; i < numberOfMatchingNumbers; i++) {
          tempPoints = tempPoints + tempPoints;
        }
      }
      points += tempPoints;
    }
    return points;
  }
}
