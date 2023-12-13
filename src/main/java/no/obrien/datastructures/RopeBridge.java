package no.obrien.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;

public class RopeBridge {

  private final List<RopeBridgeKnot> ropeBridge;

  @Getter
  private final Set<RopeBridgeKnot> hitMap = new HashSet<>();

  public RopeBridge(int size) {
    this.ropeBridge = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      ropeBridge.add(new RopeBridgeKnot());
    }
    hitMap.add(new RopeBridgeKnot(getTail().getX(), getTail().getY()));
  }

  private static RopeBridgeKnot moveTail(RopeBridgeKnot head, RopeBridgeKnot tail) {
    if (tail.isTouching(head)) {
      return tail;
    } else if (tail.getY() == head.getY()) {
      return tail.moveOneStep(tail.getX() < head.getX() ? 1 : -1, 0);
    } else if (tail.getX() == head.getX()) {
      return tail.moveOneStep(0, tail.getY() < head.getY() ? 1 : -1);
    } else if (tail.getY() < head.getY()) {
      return tail.moveOneStep(tail.getX() < head.getX() ? 1 : -1, 1);
    } else {
      return tail.moveOneStep(tail.getX() < head.getX() ? 1 : -1, -1);
    }
  }

  public RopeBridgeKnot getTail() {
    return ropeBridge.get(ropeBridge.size() - 1);
  }

  public void moveUp(int amount) {
    move(0, 1, amount);
  }

  public void moveDown(int amount) {
    move(0, -1, amount);
  }

  public void moveLeft(int amount) {
    move(-1, 0, amount);
  }

  public void moveRight(int amount) {
    move(1, 0, amount);
  }

  private void move(int deltaX, int deltaY, int amount) {
    for (var i = 0; i < amount; ++i) {
      ropeBridge.set(0, ropeBridge.get(0).moveOneStep(deltaX, deltaY));
      for (int j = 1; j < ropeBridge.size(); ++j) {
        ropeBridge.set(j, moveTail(ropeBridge.get(j - 1), ropeBridge.get(j)));
      }
      hitMap.add(new RopeBridgeKnot(this.getTail().getX(), this.getTail().getY()));
    }
  }
}
