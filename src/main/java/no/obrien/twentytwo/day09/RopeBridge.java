package no.obrien.twentytwo.day09;

import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RopeBridge {

  public int partOne(List<String> lines) {
    no.obrien.datastructures.RopeBridge ropeBridge = new no.obrien.datastructures.RopeBridge(2);
    lines.stream()
        .filter(l -> !l.isEmpty())
        .forEach(line -> parseInstruction(line, ropeBridge));

    return ropeBridge.getHitMap().size();
  }

  public int partTwo(List<String> lines) {
    no.obrien.datastructures.RopeBridge ropeBridge = new no.obrien.datastructures.RopeBridge(10);
    lines.stream()
        .filter(l -> !l.isEmpty())
        .forEach(line -> parseInstruction(line, ropeBridge));

    return ropeBridge.getHitMap().size();
  }

  private void parseInstruction(
      String instruction,
      no.obrien.datastructures.RopeBridge ropeBridge) {
    String direction = instruction.split(" ")[0];
    int amount = Integer.parseInt(instruction.split(" ")[1]);

    switch (direction) {
      case "U" -> ropeBridge.moveUp(amount);
      case "D" -> ropeBridge.moveDown(amount);
      case "L" -> ropeBridge.moveLeft(amount);
      case "R" -> ropeBridge.moveRight(amount);
    }
  }
}
