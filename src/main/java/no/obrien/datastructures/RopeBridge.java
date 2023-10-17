package no.obrien.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;

public class RopeBridge {

  private final List<Tuple<Integer>> bridge;

  @Getter
  private final Set<Tuple<Integer>> hitMap = new HashSet<>();

  public RopeBridge(int size) {
    this.bridge = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      bridge.add(new Tuple<>(0, 0));
    }
    hitMap.add(new Tuple<>(getTail().getX(), getTail().getY()));
  }

  public Tuple<Integer> getTail() {
    return bridge.get(bridge.size() - 1);
  }

  public void moveUp(int amount) {
    for (int i = 0; i < amount; i++) {
      move(0, 1);
    }
  }

  public void moveDown(int amount) {
    for (int i = 0; i < amount; i++) {
      move(0, -1);
    }
  }

  public void moveLeft(int amount) {
    for (int i = 0; i < amount; i++) {
      move(-1, 0);
    }
  }

  public void moveRight(int amount) {
    for (int i = 0; i < amount; i++) {
      move(1, 0);
    }
  }

  private void move(int deltaX, int deltaY) {
    for (int j = 0; j < bridge.size() - 1; j++) {
      boolean isRequiresMove = false;

      bridge.get(j).setX(bridge.get(j).getX() + deltaX);
      if (Math.abs(bridge.get(j).getX() - bridge.get(j + 1).getX()) > 1) {
        bridge.get(j + 1).setX(bridge.get(j + 1).getX() + deltaX);
        bridge.get(j + 1).setY(bridge.get(j).getY());

        isRequiresMove = j != bridge.size() - 2
            && Math.abs(bridge.get(j + 1).getX() - bridge.get(j + 2).getX()) > 1;
      }

      bridge.get(j).setY(bridge.get(j).getY() + deltaY);
      if (Math.abs(bridge.get(j).getY() - bridge.get(j + 1).getY()) > 1) {
        bridge.get(j + 1).setY(bridge.get(j + 1).getY() + deltaY);
        bridge.get(j + 1).setX(bridge.get(j).getX());

        isRequiresMove = j != bridge.size() - 2
            && Math.abs(bridge.get(j + 1).getY() - bridge.get(j + 2).getY()) > 1;
      }

      if (j == bridge.size() - 2) {
        hitMap.add(new Tuple<>(
            bridge.get(bridge.size() - 1).getX(),
            bridge.get(bridge.size() - 1).getY()));
      }

      if (!isRequiresMove) {
        break;
      }
    }
  }
}
