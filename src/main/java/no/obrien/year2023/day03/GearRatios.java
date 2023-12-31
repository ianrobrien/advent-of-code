package no.obrien.year2023.day03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import no.obrien.datastructures.Tuple;

@UtilityClass
public class GearRatios {

  public int partOne(List<String> lines) {
    var points = new HashSet<Tuple<Integer>>();
    for (int y = 0; y < lines.size(); ++y) {
      var line = lines.get(y);
      for (int x = 0; x < line.length(); ++x) {
        var point = new Tuple<>(x, y);
        if (isSymbol(line.charAt(x))) {
          findTouchingDigits(point).stream()
              .filter(
                  c -> isValid(lines, c)
                      && Character.isDigit(lines.get(c.getSecond()).charAt(c.getFirst())))
              .map(c -> findFirstChar(lines, c)).forEach(points::add);
        }
      }
    }
    return points.stream().mapToInt(c -> readNumberFrom(lines, c)).sum();
  }

  public long partTwo(List<String> lines) {
    int sum = 0;
    for (int y = 0; y < lines.size(); ++y) {
      var line = lines.get(y);
      for (int x = 0; x < line.length(); ++x) {
        var point = new Tuple<>(x, y);
        var character = line.charAt(x);
        if (isSymbol(character)) {
          Set<Tuple<Integer>> candidates = findTouchingDigits(point).stream()
              .filter(
                  c -> isValid(lines, c)
                      && Character.isDigit(lines.get(c.getSecond()).charAt(c.getFirst())))
              .map(c -> findFirstChar(lines, c))
              .collect(Collectors.toSet());
          if (candidates.size() == 2) {
            sum += candidates.stream()
                .mapToInt(c -> readNumberFrom(lines, c))
                .reduce(1, (a, b) -> a * b);
          }
        }
      }
    }
    return sum;
  }

  private List<Tuple<Integer>> findTouchingDigits(
      Tuple<Integer> symbol) {
    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};

    var result = new ArrayList<Tuple<Integer>>();
    for (int i = 0; i < dx.length; i++) {
      result.add(new Tuple<>(symbol.getFirst() + dx[i], symbol.getSecond() + dy[i]));
    }
    return result.stream().toList();
  }

  private boolean isValid(List<String> lines, Tuple<Integer> tuple) {
    return tuple.getSecond() >= 0 && tuple.getSecond() < lines.size()
        && tuple.getFirst() >= 0 && tuple.getFirst() < lines.get(tuple.getSecond()).length();
  }

  private boolean isSymbol(char c) {
    return c != '.' && !Character.isDigit(c);
  }

  private Tuple<Integer> findFirstChar(List<String> lines, Tuple<Integer> point) {
    var line = lines.get(point.getSecond());
    var x = point.getFirst();
    while (x > 0 && Character.isDigit(line.charAt(x - 1))) {
      --x;
    }
    return new Tuple<>(x, point.getSecond());
  }

  private static int readNumberFrom(List<String> lines, Tuple<Integer> startPoint) {
    var line = lines.get(startPoint.getSecond());
    var x = startPoint.getFirst();
    while (x < line.length() && Character.isDigit(line.charAt(x))) {
      ++x;
    }
    return Integer.parseInt(line.substring(startPoint.getFirst(), x));
  }
}
