package no.obrien.twentythree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;
import no.obrien.datastructures.Tuple;

@UtilityClass
public class HauntedWasteland {

  private static final String NODE_REGEX = "(\\w+)\\s*=\\s*\\((\\w+),\\s*(\\w+)\\)";
  private static final Pattern NODE_PATTERN = Pattern.compile(NODE_REGEX);

  public int partOne(List<String> lines) {
    int result = 0;
    var steps = lines.get(0);

    var nodeNetwork = buildNodeNetwork(lines);

    var currentNode = "AAA";
    while (!Objects.equals(currentNode, "ZZZ")) {
      for (Character c : steps.toCharArray()) {
        switch (c) {
          case 'L' -> {
            currentNode = nodeNetwork.get(currentNode).getFirst();
            result++;
          }
          case 'R' -> {
            currentNode = nodeNetwork.get(currentNode).getSecond();
            result++;
          }
        }
        if (Objects.equals(currentNode, "ZZZ")) {
          break;
        }
      }
    }

    return result;
  }

  public int partTwo(List<String> lines) {
    int result = 0;
    var steps = lines.get(0);

    var nodeNetwork = buildNodeNetwork(lines);
    var startNodes = nodeNetwork.keySet().stream()
        .filter(s -> s.endsWith("A"))
        .toList();

    var currentNodes = new ArrayList<>(startNodes);

    while (currentNodes.stream()
        .filter(s -> s.endsWith("Z"))
        .toList()
        .size() != currentNodes.size()) {
      for (Character c : steps.toCharArray()) {
        switch (c) {
          case 'L' -> {
            for (var currentNode : currentNodes) {
              currentNodes.add(nodeNetwork.get(currentNode).getFirst());
              currentNodes.remove(currentNode);
            }
            result++;
          }
          case 'R' -> {
            for (var currentNode : currentNodes) {
              currentNodes.add(nodeNetwork.get(currentNode).getSecond());
              currentNodes.remove(currentNode);
            }
            result++;
          }
        }
        if (currentNodes.stream()
            .filter(s -> s.endsWith("Z"))
            .toList()
            .size() == currentNodes.size()) {
          break;
        }
      }
    }

    return result;
  }

  private LinkedHashMap<String, Tuple<String>> buildNodeNetwork(
      List<String> lines) {
    var nodeNetwork = new LinkedHashMap<String, Tuple<String>>();
    for (int i = 2; i < lines.size(); i++) {
      var matcher = NODE_PATTERN.matcher(lines.get(i));
      if (matcher.find()) {
        var node = matcher.group(1);
        var left = matcher.group(2);
        var right = matcher.group(3);
        nodeNetwork.put(node, new Tuple<>(left, right));
      }
    }
    return nodeNetwork;
  }
}
