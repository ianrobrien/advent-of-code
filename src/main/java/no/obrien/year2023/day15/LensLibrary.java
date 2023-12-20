package no.obrien.year2023.day15;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LensLibrary {

  private static final Pattern STEP_PATTERN = Pattern.compile("([^=]+)(=|-)([^=]*)");

  public long partOne(List<String> lines) {
    int hashValue = 0;
    for (String line : lines) {
      var tokens = line.split(",");
      for (var token : tokens) {
        hashValue += calculateHash(token);
      }
    }
    return hashValue;
  }

  public int partTwo(List<String> lines) {
    var hashMap = new ArrayList<LinkedHashMap<String, Integer>>(256);
    for (int i = 0; i < 256; i++) {
      hashMap.add(new LinkedHashMap<>());
    }

    for (var line : lines) {
      var tokens = line.split(",");
      for (var token : tokens) {
        var matcher = STEP_PATTERN.matcher(token);
        if (matcher.find()) {
          var label = matcher.group(1);
          var operation = matcher.group(2);
          var focalLength = matcher.group(3);

          var boxNumber = calculateHash(label);
          var lenses = hashMap.get(boxNumber);

          switch (operation) {
            case "=" -> lenses.put(label, Integer.parseInt(focalLength));
            case "-" -> lenses.remove(label);
          }
        } else {
          throw new RuntimeException("String format doesn't match the pattern.");
        }
      }
    }

    int focusingPower = 0;
    int boxNumber = 1;
    for (var lenses : hashMap) {
      int slot = 1;
      for (var lens : lenses.entrySet()) {
        focusingPower += boxNumber * slot++ * lens.getValue();
      }
      boxNumber++;
    }

    return focusingPower;
  }

  private int calculateHash(String string) {
    int tokenHash = 0;
    for (var c : string.toCharArray()) {
      tokenHash += c;
      tokenHash *= 17;
      tokenHash %= 256;
    }
    return tokenHash;
  }
}
