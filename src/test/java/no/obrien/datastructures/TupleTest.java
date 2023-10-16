package no.obrien.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TupleTest {

  @Test
  void testEquals() {
    Tuple<Integer> tuple1 = new Tuple<>(1, 2);
    Tuple<Integer> tuple2 = new Tuple<>(1, 2);

    // Tuples should be equal if they have the same values
    assertEquals(tuple1, tuple2);
    // Tuples should not be the same object
    assertNotSame(tuple1, tuple2);
  }

  @Test
  void testList() {
    List<Tuple<Integer>> list = new ArrayList<>();
    Tuple<Integer> tuple1 = new Tuple<>(1, 2);
    list.add(tuple1);

    Tuple<Integer> tuple2 = new Tuple<>(1, 2);
    assertTrue(list.contains(tuple2));
  }

  @Test
  void testMap() {
    Map<Tuple<Integer>, Boolean> map = new HashMap<>();
    Tuple<Integer> tuple1 = new Tuple<>(1, 2);
    map.put(tuple1, true);

    Tuple<Integer> tuple2 = new Tuple<>(1, 2);
    assertTrue(map.containsKey(tuple2));
  }

  @Test
  void testSet() {
    Set<Tuple<Integer>> set = new HashSet<>();
    Tuple<Integer> tuple1 = new Tuple<>(1, 2);
    set.add(tuple1);

    Tuple<Integer> tuple2 = new Tuple<>(1, 2);
    set.add(tuple2);

    assertEquals(1, set.size());
  }
}