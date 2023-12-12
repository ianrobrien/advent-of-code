package no.obrien.twentythree.day04;

import java.util.Arrays;
import java.util.HashMap;
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

  public int partTwo(List<String> lines) {
    var cards = new HashMap<Integer, Integer>();
    cards.put(1, 1);
    int cardNumber = 1;

    for (int i = 0; i < lines.size(); i++) {
      cards.put(i + 1, 1);
    }

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

      if (numberOfMatchingNumbers > 0) {
        for (int i = 0; i < cards.getOrDefault(cardNumber, 1); i++) {
          for (int j = 0; j < numberOfMatchingNumbers; j++) {
            cards.put(cardNumber + 1 + j, cards.get(j + 1 + cardNumber) + 1);
          }
        }
      }
      cardNumber++;
    }
    return cards.values().stream().mapToInt(Integer::intValue).sum();
  }
}
