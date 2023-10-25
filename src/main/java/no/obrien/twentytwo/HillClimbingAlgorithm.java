package no.obrien.twentytwo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import no.obrien.datastructures.Tuple;
import no.obrien.utils.FileUtils;

public class HillClimbingAlgorithm {

  private static final List<Tuple<Integer>> MOVES = List.of(
      new Tuple<>(1, 0),
      new Tuple<>(-1, 0),
      new Tuple<>(0, 1),
      new Tuple<>(0, -1));

  public int partOne(String inputFilePath) {
    var map = buildMap(inputFilePath);

    var start = map.keySet().stream()
        .filter(k -> map.get(k) == 'S')
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No start found"));
    var end = map.keySet().stream()
        .filter(k -> map.get(k) == 'E')
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No end found"));

    map.put(start, (byte) 'a');
    map.put(end, (byte) 'z');

    return shortestPath(map, start, dh -> dh <= 1, p -> p.equals(end));
  }

  public int partTwo(String inputFilePath) {
    var map = buildMap(inputFilePath);

    var start = map.keySet().stream()
        .filter(k -> map.get(k) == 'S')
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No start found"));
    var end = map.keySet().stream()
        .filter(k -> map.get(k) == 'E')
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No end found"));

    map.put(start, (byte) 'a');
    map.put(end, (byte) 'z');

    return shortestPath(map, end, dh -> dh >= -1, p -> map.get(p) == 'a');
  }

  record Visit(Tuple<Integer> xy, int distance) {

    Visit move(Tuple<Integer> v) {
      return new Visit(new Tuple<>(
          xy.getX() + v.getX(),
          xy.getY() + v.getY()),
          distance + 1);
    }
  }

  private int shortestPath(
      Map<Tuple<Integer>, Byte> map,
      Tuple<Integer> start,
      Function<Byte, Boolean> isCanClimb,
      Function<Tuple<Integer>, Boolean> isEnd) {

    var visited = new HashMap<Tuple<Integer>, Integer>();
    var toVisit = new LinkedList<Visit>();
    toVisit.add(new Visit(start, 0));

    while (!toVisit.isEmpty()) {
      var c = toVisit.removeFirst();
      if (!visited.containsKey(c.xy)
          || visited.get(c.xy) > c.distance) {
        visited.put(c.xy, c.distance);
        MOVES.stream().map(c::move)
            .filter(n -> map.containsKey(n.xy))
            .filter(n -> isCanClimb.apply((byte) (map.get(n.xy) - map.get(c.xy))))
            .forEach(toVisit::add);
      }
    }

    return visited.keySet().stream()
        .filter(isEnd::apply)
        .map(visited::get)
        .sorted()
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No path found"));
  }

  private Map<Tuple<Integer>, Byte> buildMap(String inputFilePath) {
    List<String> lines = FileUtils.parseInputFile(inputFilePath)
        .stream()
        .filter(line -> !line.isEmpty())
        .toList();

    Map<Tuple<Integer>, Byte> map = new HashMap<>();
    for (int y = 0; y < lines.size(); y++) {
      for (int x = 0; x < lines.get(y).length(); x++) {
        map.put(new Tuple<>(x, y), (byte) lines.get(y).charAt(x));
      }
    }
    return map;
  }
}
