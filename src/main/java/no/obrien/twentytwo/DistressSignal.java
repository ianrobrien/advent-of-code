package no.obrien.twentytwo;

import java.util.List;
import lombok.experimental.UtilityClass;
import no.obrien.utils.FileUtils;

@UtilityClass
public class DistressSignal {

  public int partOne(String inputFilePath) {
    var distressSignals = FileUtils.parseInputFile(inputFilePath, 2);
    return processLists(distressSignals);
  }

  private int processLists(List<List<String>> distressSignals) {
    return 0;
  }
}
