package no.obrien.twentytwo.day03;

import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import no.obrien.utils.FileUtils;

@UtilityClass
@Slf4j
public class RucksackReorganization {

  private static final Map<Character, Integer> PRIORITY_VALUES = new HashMap<>();

  static {
    for (int i = 0; i < 26; i++) {
      char key = (char) ('a' + i);
      int value = i + 1;
      PRIORITY_VALUES.put(key, value);
    }
    for (int i = 0; i < 26; i++) {
      char key = (char) ('A' + i);
      int value = i + 27;
      PRIORITY_VALUES.put(key, value);
    }
  }

  public int partOne(String filePath) {
    return FileUtils.parseInputFile(filePath)
        .stream()
        .map(RucksackReorganization::calculatePriorityPartOne)
        .mapToInt(Integer::intValue)
        .sum();
  }

  @SneakyThrows
  public int partTwo(String filePath) {
    var input = FileUtils.parseInputFile(filePath);

    int score = 0;
    String first = null;
    String second = null;
    for (int i = 0; i < input.size(); i++) {
      if (i % 3 == 0) {
        first = input.get(i);
      }
      if (i % 3 == 1) {
        second = input.get(i);
      }
      if (i % 3 == 2) {
        score += calculatePriorityPartTwo(first, second, input.get(i));
      }
    }

    return score;
  }

  private int calculatePriorityPartOne(String itemsString) {
    String compartment1 = itemsString.substring(0, itemsString.length() / 2);
    String compartment2 = itemsString.substring(itemsString.length() / 2);

    char[] items = compartment1.toCharArray();
    Character duplicate = null;
    for (int i = 0; i < items.length; i++) {
      if (compartment2.contains(String.valueOf(items[i]))) {
        duplicate = compartment1.charAt(i);
      }
    }

    return PRIORITY_VALUES.get(duplicate);
  }

  private int calculatePriorityPartTwo(String first, String second, String third) throws Exception {
    char[] items = first.toCharArray();

    for (int i = 0; i < items.length; i++) {
      if (second.contains(String.valueOf(items[i]))) {
        char duplicate = first.charAt(i);
        for (int j = 0; j < items.length; j++) {
          if (third.contains(Character.toString(duplicate))) {
            return PRIORITY_VALUES.get(duplicate);
          }
        }
      }
    }

    throw new Exception("No duplicate found");
  }
}
