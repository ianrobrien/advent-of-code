package no.obrien.year2022.day10;

import java.util.ArrayList;
import java.util.List;
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

  public String partTwo(String inputFilePath) {
    List<String> lines = FileUtils.parseInputFile(inputFilePath)
        .stream()
        .filter(line -> !line.isEmpty())
        .toList();

    int pc = 0;
    int x = 1;
    boolean isDrawing = false;

    // initialize output
    var output = new ArrayList<Character[]>(6);
    for (int i = 0; i < 6; i++) {
      output.add(new Character[40]);
      for (int j = 0; j < 40; j++) {
        output.get(i)[j] = '.';
      }
    }

    for (int cycle = 1; cycle < 1000; cycle++) {
      if (pc == lines.size()) {
        break;
      }
      int row = cycle / 40;
      int column = (cycle - 1) % 40;
      if (x <= column + 1 && x >= column - 1) {
        output.get(row)[column] = '#';
      }
      String line = lines.get(pc);
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

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      for (Character character : output.get(i)) {
        stringBuilder.append(character);
      }
    }

    return stringBuilder.toString();
  }

  private int calculateSignalStrength(int cycleCount, int x) {
    return cycleCount == 20 || (cycleCount - 20) % 40 == 0
        ? cycleCount * x
        : 0;
  }
}
