package no.obrien.year2023.day01;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.experimental.UtilityClass;
import no.obrien.utils.FileUtils;

@UtilityClass
public class Trebuchet {

  private static final Map<String, String> NUMBERS_MAP = Map.of(
      "one", "1",
      "two", "2",
      "three", "3",
      "four", "4",
      "five", "5",
      "six", "6",
      "seven", "7",
      "eight", "8",
      "nine", "9");

  public int partOne(String filePath) {
    var result = new AtomicInteger();
    FileUtils.parseInputFile(filePath)
        .stream()
        .filter(line -> !line.isBlank())
        .forEach(line -> {
          String firstDigit = "";
          for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
              firstDigit = String.valueOf(line.charAt(i));
              break;
            }
          }

          String lastDigit = "";
          for (int i = line.length() - 1; i >= 0; i--) {
            if (Character.isDigit(line.charAt(i))) {
              lastDigit = String.valueOf(line.charAt(i));
              break;
            }
          }

          result.addAndGet(Integer.parseInt(firstDigit + lastDigit));
        });
    return result.get();
  }

  public int partTwo(List<String> lines) {
    var result = new AtomicInteger();
    lines.stream()
        .filter(line -> !line.isBlank())
        .forEach(line -> {
          String firstDigit = "";
          int firstDigitIndex = Integer.MAX_VALUE;
          for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
              firstDigit = String.valueOf(line.charAt(i));
              firstDigitIndex = i;
              break;
            }
          }

          int firstWordIndex = Integer.MAX_VALUE;
          String firstWord = "";
          for (Map.Entry<String, String> kvp : NUMBERS_MAP.entrySet()) {
            if (line.contains(kvp.getKey())) {
              var firstWordIndexTemp = line.indexOf(kvp.getKey());
              if (firstWordIndexTemp < firstDigitIndex &&
                  firstWordIndexTemp < firstWordIndex) {
                firstWordIndex = firstWordIndexTemp;
                firstWord = kvp.getKey();
              }
            }
          }

          if (firstWordIndex < firstDigitIndex) {
            firstDigit = NUMBERS_MAP.get(firstWord);
          }

          String lastDigit = "";
          int lastDigitIndex = Integer.MIN_VALUE;
          for (int i = line.length() - 1; i >= 0; i--) {
            if (Character.isDigit(line.charAt(i))) {
              lastDigit = String.valueOf(line.charAt(i));
              lastDigitIndex = i;
              break;
            }
          }

          int lastWordIndex = Integer.MIN_VALUE;
          String lastWord = "";
          for (Map.Entry<String, String> kvp : NUMBERS_MAP.entrySet()) {
            if (line.contains(kvp.getKey())) {
              var lastWordIndexTemp = line.lastIndexOf(kvp.getKey());
              if (lastWordIndexTemp > lastDigitIndex &&
                  lastWordIndexTemp > lastWordIndex) {
                lastWordIndex = lastWordIndexTemp;
                lastWord = kvp.getKey();
              }
            }
          }
          if (lastWordIndex > lastDigitIndex) {
            lastDigit = NUMBERS_MAP.get(lastWord);
          }

          result.addAndGet(Integer.parseInt(firstDigit + lastDigit));
        });

    return result.get();
  }
}
