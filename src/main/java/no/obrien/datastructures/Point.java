package no.obrien.datastructures;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Point<T> extends Tuple<Integer> {

  private T value;

  public Point(Integer x, Integer y, T value) {
    super(x, y);
    this.value = value;
  }
}
