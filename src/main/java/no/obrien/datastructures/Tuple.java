package no.obrien.datastructures;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tuple<T> {

  T x;
  T y;
}
