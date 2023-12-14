package no.obrien.twentythree.day14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ParabolicReflectorDish {

  private static final char ROCK = 'O';
  private static final char CUBE = '#';
  private static final char EMPTY = '.';

  public long partOne(List<String> lines) {
    var rotatedGrid = rotateGrid(lines);
    var tiltedGrid = tiltGrid(rotatedGrid);
    return calculateLoad(tiltedGrid);
  }

  public int partTwo(List<String> lines) {
    var result = 0;
    return result;
  }

  private List<String> rotateGrid(List<String> lines) {
    var result = new ArrayList<StringBuilder>();
    for (int rowIndex = 0; rowIndex < lines.size(); rowIndex++) {
      for (int columnIndex = 0; columnIndex < lines.get(rowIndex).length(); columnIndex++) {
        var line = lines.get(rowIndex);
        var character = line.charAt(columnIndex);
        if (result.size() <= columnIndex) {
          result.add(columnIndex, new StringBuilder());
        }
        result.get(columnIndex).append(character);
      }
    }
    return result.stream().map(StringBuilder::toString).collect(Collectors.toList());
  }

  private List<String> tiltGrid(List<String> lines) {
    var result = new ArrayList<String>();
    for (String line : lines) {
      char[] tokens = line.toCharArray();
      boolean tilted = false;
      while (!tilted) {
        tilted = true;
        for (int i = 0; i < tokens.length - 1; i++) {
          var next = tokens[i + 1];
          var current = tokens[i];
          if (current == EMPTY && next == ROCK) {
            tokens[i + 1] = EMPTY;
            tokens[i] = ROCK;
            tilted = false;
          }
        }
      }
      result.add(new String(tokens));
    }
    return result;
  }

  private long calculateLoad(List<String> lines) {
    long result = 0;
    for (int i = 0; i < lines.size(); i++) {
      for (int j = 0; j < lines.get(i).length(); j++) {
        if (lines.get(i).charAt(j) == ROCK) {
          result += (lines.size() - j);
        }
      }
    }
    return result;
  }
}