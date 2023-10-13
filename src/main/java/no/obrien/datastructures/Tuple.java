package no.obrien.datastructures;

import lombok.Value;

@Value
public class Tuple<T> {

  T x;
  T y;
}
