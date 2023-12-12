package no.obrien.datastructures;

import lombok.Data;

import java.util.Objects;

@Data
public class Tuple<T> {

  private T first;
  private T second;

  public Tuple(T first, T second) {
    this.first = Objects.requireNonNull(first);
    this.second = Objects.requireNonNull(second);
  }

  // Required for Lombok
  private Tuple() {
  }
}
