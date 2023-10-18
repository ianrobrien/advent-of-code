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

  public void moveUp() {
    move(0, 1);
  }

  public void moveDown() {
    move(0, -1);
  }

  public void moveLeft() {
    move(-1, 0);
  }

  public void moveRight() {
    move(1, 0);
  }

  private void move(int deltaX, int deltaY) {
    for (int i = 0; i < bridge.size() - 1; i++) {
      bridge.get(i).setX(bridge.get(i).getX() + deltaX);
      if (Math.abs(bridge.get(i).getX() - bridge.get(i + 1).getX()) > 1) {
        bridge.get(i + 1).setX(bridge.get(i + 1).getX() + deltaX);
        bridge.get(i + 1).setY(bridge.get(i).getY());
      }

      bridge.get(i).setY(bridge.get(i).getY() + deltaY);
      if (Math.abs(bridge.get(i).getY() - bridge.get(i + 1).getY()) > 1) {
        bridge.get(i + 1).setY(bridge.get(i + 1).getY() + deltaY);
        bridge.get(i + 1).setX(bridge.get(i).getX());
      }
      
      hitMap.add(new Tuple<>(this.getTail().getX(), this.getTail().getY()));
    }
  }
}
