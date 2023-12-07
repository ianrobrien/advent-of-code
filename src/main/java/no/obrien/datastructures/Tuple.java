package no.obrien.datastructures;

import lombok.Data;

import java.util.Objects;

@Data
public class Tuple<T> {

  private T x;
  private T y;

  public Tuple(T x, T y) {
    this.x = Objects.requireNonNull(x);
    this.y = Objects.requireNonNull(y);
  }

  // Required for Lombok
  private Tuple() {
  }
}
