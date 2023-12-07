package no.obrien.twentythree;

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
    Set<Tuple<Integer>> startCoords = new HashSet<>();
    for (int y = 0; y < lines.size(); ++y) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); ++x) {
        Tuple<Integer> coord = new Tuple<>(x, y);
        char chr = line.charAt(x);
        if (isSymbol(chr)) {
          findTouchingDigits(coord).stream()
              .filter(
                  c -> isValid(lines, c)
                      && Character.isDigit(lines.get(c.getY()).charAt(c.getX())))
              .map(c -> findFirstChar(lines, c)).forEach(startCoords::add);
        }
      }
    }
    return startCoords.stream().mapToInt(c -> readNumberFrom(lines, c)).sum();
  }

  public long partTwo(List<String> lines) {
    int sum = 0;
    for (int y = 0; y < lines.size(); ++y) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); ++x) {
        var coord = new Tuple<>(x, y);
        char chr = line.charAt(x);
        if (isSymbol(chr)) {
          Set<Tuple<Integer>> candidates = findTouchingDigits(coord).stream()
              .filter(
                  c -> isValid(lines, c)
                      && Character.isDigit(lines.get(c.getY()).charAt(c.getX())))
              .map(c -> findFirstChar(lines, c))
              .collect(Collectors.toSet());
          if (candidates.size() == 2) {
            sum += candidates.stream().mapToInt(c -> readNumberFrom(lines, c))
                .reduce(1, (a, b) -> a * b);
          }
        }
      }
    }
    return sum;
  }


  private List<Tuple<Integer>> findTouchingDigits(
      Tuple<Integer> symbol) {
    var result = new ArrayList<Tuple<Integer>>();

    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};

    for (int i = 0; i < dx.length; i++) {
      int x = symbol.getX() + dx[i];
      int y = symbol.getY() + dy[i];
      result.add(new Tuple<>(x, y));

    }
    return result.stream().toList();
  }

  boolean isValid(List<String> lines, Tuple<Integer> tuple) {
    return 0 <= tuple.getY() && tuple.getY() < lines.size()
        && 0 <= tuple.getX() && tuple.getX() < lines.get(tuple.getY()).length();
  }

  private static boolean isSymbol(char c) {
    return c != '.' && !Character.isDigit(c);
  }

  private static Tuple<Integer> findFirstChar(List<String> lines, Tuple<Integer> coord) {
    String line = lines.get(coord.getY());
    int x = coord.getX();
    while (x > 0 && Character.isDigit(line.charAt(x - 1))) {
      --x;
    }
    return new Tuple<>(x, coord.getY());
  }

  private static int readNumberFrom(List<String> lines, Tuple<Integer> startCoord) {
    String line = lines.get(startCoord.getY());
    int x = startCoord.getX();
    while (x < line.length() && Character.isDigit(line.charAt(x))) {
      ++x;
    }
    return Integer.parseInt(line.substring(startCoord.getX(), x));
  }
}
