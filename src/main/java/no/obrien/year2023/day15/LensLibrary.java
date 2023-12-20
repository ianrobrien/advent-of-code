package no.obrien.year2023.day15;

import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LensLibrary {

  public long partOne(List<String> lines) {
    int hashValue = 0;
    for (String line : lines) {
      var tokens = line.split(",");
      for (var token : tokens) {
        int tokenHash = 0;
        for (var c : token.toCharArray()) {
          tokenHash = calculateHash(c, tokenHash);
        }
        hashValue += tokenHash;
      }
    }
    return hashValue;
  }

  private int calculateHash(char c, int tokenHash) {
    tokenHash += c;
    tokenHash *= 17;
    tokenHash %= 256;
    return tokenHash;
  }

  public int partTwo(List<String> lines) {
    return 0;
  }
}
