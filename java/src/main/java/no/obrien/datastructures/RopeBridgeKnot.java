package no.obrien.datastructures;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class RopeBridgeKnot {

  private final Tuple<Integer> position;

  public RopeBridgeKnot() {
    this(0, 0);
  }

  public RopeBridgeKnot(int x, int y) {
    this.position = new Tuple<>(x, y);
  }

  public int getX() {
    return position.getFirst();
  }

  public int getY() {
    return position.getSecond();
  }

  boolean isTouching(RopeBridgeKnot knot) {
    return Math.abs(this.getX() - knot.getX()) <= 1 && Math.abs(this.getY() - knot.getY()) <= 1;
  }

  RopeBridgeKnot moveOneStep(int xDelta, int yDelta) {
    return new RopeBridgeKnot(this.getX() + xDelta, this.getY() + yDelta);
  }
}
