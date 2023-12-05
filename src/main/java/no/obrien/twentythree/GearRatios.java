package no.obrien.twentythree;

import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GearRatios {

  public int partOne(List<String> lines) {
    List<Integer> result = new ArrayList<>();
    int row = 0;
    int index = 0;
    for (String line : lines) {
      StringBuilder partNumber = new StringBuilder();
      char[] chars = line.toCharArray();
      boolean addPartNumber = false;
      for (char c : chars) {
        if (Character.isDigit(c)) {
          partNumber.append(c);
          // look left
          if (index > 0) {
            if (chars[index - 1] != '.' && !Character.isDigit(chars[index - 1])) {
              addPartNumber = true;
            }
          }
          // look right
          if (index < chars.length - 1) {
            if (chars[index + 1] != '.' && !Character.isDigit(chars[index + 1])) {
              addPartNumber = true;
            }
          }
          // look up
          if (row > 0) {
            String previousLine = lines.get(row - 1);
            for (int i = Math.max(index - 1, 0); i <= Math.min(index + 1, line.length() - 1); i++) {
              if (previousLine.charAt(i) != '.' && !Character.isDigit(previousLine.charAt(i))) {
                addPartNumber = true;
              }
            }
          }
          // look down
          if (row < lines.size() - 1) {
            String nextLine = lines.get(row + 1);
            for (int i = Math.max(index - 1, 0); i <= Math.min(index + 1, line.length() - 1); i++) {
              if (nextLine.charAt(i) != '.' && !Character.isDigit(nextLine.charAt(i))) {
                addPartNumber = true;
              }
            }
          }
          if (index == chars.length - 1 && addPartNumber) {
            result.add(Integer.parseInt(partNumber.toString()));
            addPartNumber = false;
          }
        } else {
          if (addPartNumber) {
            result.add(Integer.parseInt(partNumber.toString()));
            addPartNumber = false;
          }
          partNumber.setLength(0);
        }
        index++;
      }
      row++;
      index = 0;
    }
    return result.stream().mapToInt(Integer::intValue).sum();
  }

  public int partTwo(List<String> lines) {
    int result = 0;
    return result;
  }
}
