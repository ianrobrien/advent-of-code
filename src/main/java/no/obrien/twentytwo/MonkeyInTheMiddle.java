package no.obrien.twentytwo;

import lombok.experimental.UtilityClass;
import no.obrien.utils.FileUtils;
import java.util.List;

@UtilityClass
public class MonkeyInTheMiddle {

  public int partOne(String inputFilePath) {
    List<String> lines = FileUtils.parseInputFile(inputFilePath)
        .stream()
        .filter(line -> !line.isEmpty())
        .toList();

    return 0;
  }
}
