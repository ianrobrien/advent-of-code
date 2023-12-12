package no.obrien.twentythree.day08;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;
import no.obrien.datastructures.Tuple;
import no.obrien.utils.MathUtils;

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

  public BigInteger partTwo(List<String> lines) {
    var steps = lines.get(0);

    var nodeNetwork = buildNodeNetwork(lines);
    var startNodes = nodeNetwork.keySet().stream()
        .filter(s -> s.endsWith("A"))
        .toList();

    var stepsPerNode = new ArrayList<Integer>();
    for (String startNode : startNodes) {
      var currentNode = startNode;
      int stepsCount = 0;
      while (!currentNode.endsWith("Z")) {
        for (Character c : steps.toCharArray()) {
          stepsCount++;
          switch (c) {
            case 'L' -> currentNode = nodeNetwork.get(currentNode).getFirst();
            case 'R' -> currentNode = nodeNetwork.get(currentNode).getSecond();
          }
          if (currentNode.endsWith("Z")) {
            stepsPerNode.add(stepsCount);
            break;
          }
        }
      }
    }

    return MathUtils.findLCM(stepsPerNode);
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
