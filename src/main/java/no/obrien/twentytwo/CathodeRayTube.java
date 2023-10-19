package no.obrien.twentytwo;

import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import no.obrien.utils.FileUtils;

@UtilityClass
public class CathodeRayTube {

  public long partOne(String inputFilePath) {
    List<String> lines = FileUtils.parseInputFile(inputFilePath)
        .stream()
        .filter(line -> !line.isEmpty())
        .toList();

    int pc = 0;
    int x = 1;
    int signalStrengthSum = 0;
    boolean isDrawing = false;

    for (int cycle = 1; cycle < 1000; cycle++) {
      if (pc == lines.size()) {
        break;
      }
      String line = lines.get(pc);
      signalStrengthSum += calculateSignalStrength(cycle, x);
      if (isDrawing) {
        int argument = Integer.parseInt(line.split(" ")[1]);
        x += argument;
        isDrawing = false;
        pc++;
      } else {
        String instruction = line.split(" ")[0];
        if (instruction.equals("noop")) {
          pc++;
        } else if (instruction.equals("addx")) {
          isDrawing = true;
        } else {
          throw new RuntimeException("Unknown instruction: " + instruction);
        }
      }
    }

    return signalStrengthSum;
  }

  private int calculateSignalStrength(int cycleCount, int x) {
    return cycleCount == 20 || (cycleCount - 20) % 40 == 0
        ? cycleCount * x
        : 0;
  }
}
