package no.obrien.twentythree;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CubeConundrum {

  private static final Pattern GAME_ID_PATTERN = Pattern.compile("Game\\s(\\d+)");
  private static final int RED_CUBES_COUNT = 12;
  private static final int GREEN_CUBES_COUNT = 13;
  private static final int BLUE_CUBES_COUNT = 14;

  private static final String BLUE = "blue";
  private static final String RED = "red";
  private static final String GREEN = "green";

  public int partOne(List<String> lines) {
    int result = 0;
    for (String line : lines) {
      int gameId = getGameId(line);
      System.out.println("Game: " + line);
      System.out.println("GameId: " + gameId);
      String[] firstGroups = line.split(":\\s", 2); // Splitting after the first colon
      String[] sets = firstGroups[1].split(";\\s");
      boolean gameValid = true;
      for (String set : sets) {
        System.out.println("Set: " + set);
        String[] cubes = set.split(",\\s");
        for (String cube : cubes) {
          String[] colorAndCount = cube.split("\\s", 2);
          if (colorAndCount.length == 2) {
            int number = Integer.parseInt(colorAndCount[0]);
            String color = colorAndCount[1];

            switch (color) {
              case RED -> {
                if (number > RED_CUBES_COUNT) {
                  gameValid = false;
                }
              }
              case GREEN -> {
                if (number > GREEN_CUBES_COUNT) {
                  gameValid = false;
                }
              }
              case BLUE -> {
                if (number > BLUE_CUBES_COUNT) {
                  gameValid = false;
                }
              }
            }
            System.out.println("Number = " + number + ", Color = " + color);
          } else {
            throw new RuntimeException("Could not parse cube: " + cube);
          }
        }
      }
      if (gameValid) {
        result += gameId;
      }
    }
    return result;
  }

  private int getGameId(String line) {
    Matcher matcher = GAME_ID_PATTERN.matcher(line);
    if (!matcher.find()) {
      throw new RuntimeException("Could not find game id in line: " + line);
    }
    String gameNumber = matcher.group(1);
    return Integer.parseInt(gameNumber);
  }
}
