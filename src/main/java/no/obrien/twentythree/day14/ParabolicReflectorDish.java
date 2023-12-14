package no.obrien.twentythree.day14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ParabolicReflectorDish {

  private static final char ROCK = 'O';
  private static final char EMPTY = '.';

  public long partOne(List<String> lines) {
    return calculateLoad(tiltNorth(createGrid(lines)));
  }

  public long partTwo(List<String> lines) {
    Map<String, Long> index = new HashMap<>();
    var grid = createGrid(lines);
    for (long i = 0; i < 1000000000; i++) {
      grid = runCycle(grid);
      String str = calculateKey(grid);
      if (index.containsKey(str)) {
        long delta = i - index.get(str);
        i += delta * ((1000000000 - i) / delta);
      }
      index.put(str, i);
    }
    return calculateLoad(grid);
  }

  private char[][] createGrid(List<String> lines) {
    char[][] grid = new char[lines.get(0).length()][lines.size()];
    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++) {
        grid[x][y] = line.charAt(x);
      }
    }
    return grid;
  }

  private static char[][] tiltNorth(char[][] grid) {
    int width = grid.length;
    int height = grid[0].length;
    for (int x = 0; x < width; x++) {
      boolean move = true;
      while (move) {
        move = false;
        for (int y = 1; y < height; y++) {
          if (grid[x][y] == ROCK && grid[x][y - 1] == EMPTY) {
            grid[x][y] = EMPTY;
            grid[x][y - 1] = ROCK;
            move = true;
          }
        }
      }
    }
    return grid;
  }

  private static long calculateLoad(char[][] grid) {
    int height = grid[0].length;
    long result = 0;
    for (char[] chars : grid) {
      for (int y = 0; y < height; y++) {
        if (chars[y] == ROCK) {
          result += height - y;
        }
      }
    }
    return result;
  }

  private char[][] rotateGrid(char[][] grid) {
    int width = grid.length;
    int height = grid[0].length;
    char[][] result = new char[height][width];
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        result[x][y] = grid[y][height - x - 1];
      }
    }
    return result;
  }

  private char[][] runCycle(char[][] grid) {
    for (int i = 0; i < 4; i++) {
      grid = rotateGrid(tiltNorth(grid));
    }
    return grid;
  }

  private String calculateKey(char[][] map) {
    return Arrays.stream(map)
        .map(String::new)
        .collect(Collectors.joining());
  }
}