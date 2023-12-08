package no.obrien.twentythree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WaitForIt {

  public int partOne(List<String> lines) {
    String timesString = lines.get(0);
    String[] timeParts = timesString.split(":")[1].trim().split("\\s+");
    List<Integer> times = Arrays.stream(timeParts).map(Integer::parseInt).toList();

    String distancesString = lines.get(1);
    String[] distancesParts = distancesString.split(":")[1].trim().split("\\s+");
    List<Integer> distances = Arrays.stream(distancesParts).map(Integer::parseInt).toList();

    var races = new LinkedHashMap<Integer, Integer>();
    for (int i = 0; i < distances.size(); i++) {
      races.put(times.get(i), distances.get(i));
    }

    int result = 1;
    for (var race : races.entrySet()) {
      int time = race.getKey();
      int distance = race.getValue();

      int waysToWin = 0;
      for (int i = 0; i < time; i++) {
        int distanceCovered = i * (time - i);
        if (distanceCovered > distance) {
          waysToWin++;
        }
      }
      if (waysToWin > 0) {
        result = result * waysToWin;
      }
    }
    return result;
  }

  public int partTwo(List<String> lines) {
    return 0;
  }
}
