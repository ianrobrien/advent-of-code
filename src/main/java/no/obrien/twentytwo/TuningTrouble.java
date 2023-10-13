package no.obrien.twentytwo;

import lombok.experimental.UtilityClass;
import no.obrien.utils.FileUtils;

@UtilityClass
public class TuningTrouble {

  public int partOne(String inputFile) {
    String signal = FileUtils.parseInputFile(inputFile).get(0);
    return findNonDistinct(signal, 4);
  }

  public int partTwo(String inputFile) {
    String signal = FileUtils.parseInputFile(inputFile).get(0);
    return findNonDistinct(signal, 14);
  }

  private int findNonDistinct(String input, int numNonDistinct) {
    for (int i = 0; i < input.length() - numNonDistinct; i++) {
      String packet = input.substring(i, i + numNonDistinct);

      int distinctCharacters = packet.chars()
          .mapToObj(c -> (char) c)
          .distinct()
          .toList()
          .size();
      if (distinctCharacters == numNonDistinct) {
        return i + numNonDistinct;
      }
    }
    return -1;
  }
}
