package no.obrien.datastructures;

import lombok.Data;

@Data
public class Point<T> extends Tuple<Integer> {

  private T value;

  public Point(Integer x, Integer y, T value) {
    super(x, y);
    this.value = value;
  }
}
