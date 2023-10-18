package no.obrien.twentytwo;

import java.util.List;
import java.util.stream.IntStream;
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
    no.obrien.datastructures.RopeBridge ropeBridge = new no.obrien.datastructures.RopeBridge(9);
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
      case "U" -> IntStream.range(0, amount).forEach(a -> ropeBridge.moveUp());
      case "D" -> IntStream.range(0, amount).forEach(a -> ropeBridge.moveDown());
      case "L" -> IntStream.range(0, amount).forEach(a ->ropeBridge.moveLeft());
      case "R" -> IntStream.range(0, amount).forEach(a ->ropeBridge.moveRight());
    }
  }
}
