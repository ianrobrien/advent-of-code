package no.obrien.twentytwo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;
import no.obrien.datastructures.Monkey;
import no.obrien.utils.FileUtils;

@UtilityClass
public class MonkeyInTheMiddle {

  private final Pattern numberPattern = Pattern.compile("\\d+"); // Match one or more digits

  public int partOne(String inputFilePath) {
    List<String> lines = FileUtils.parseInputFile(inputFilePath)
        .stream()
        .filter(line -> !line.isEmpty())
        .toList();

    var monkeys = createMonkeyList(lines, 3);

    int rounds = 20;
    return playMonkeyInTheMiddle(monkeys, rounds);
  }

  public int partTwo(String inputFilePath) {
    List<String> lines = FileUtils.parseInputFile(inputFilePath)
        .stream()
        .filter(line -> !line.isEmpty())
        .toList();

    var monkeys = createMonkeyList(lines, 1);

    int rounds = 10000;
    return playMonkeyInTheMiddle(monkeys, rounds);
  }

  private static int playMonkeyInTheMiddle(List<Monkey> monkeys, int rounds) {
    for (int i = 0; i < rounds; i++) {
      for (Monkey monkey : monkeys) {
        monkey.inspectItems(monkeys);
      }
      if (i % 1000 == 0) {
        System.out.println("Round " + i);
      }
    }

    List<Monkey> top2Monkeys = monkeys.stream()
        .sorted((a, b) -> Integer.compare(b.getInspectionCount(), a.getInspectionCount()))
        .limit(2)
        .toList();

    return top2Monkeys.get(0).getInspectionCount()
        * top2Monkeys.get(1).getInspectionCount();
  }

  private List<Monkey> createMonkeyList(List<String> lines, int worryLevel) {
    List<Monkey> monkeys = new ArrayList<>();
    int currentMonkey = -1;
    for (String line : lines) {
      if (line.startsWith("Monkey")) {
        monkeys.add(new Monkey(BigInteger.valueOf(worryLevel)));
        String monkeyNumber = extractNumber(line);
        currentMonkey = Integer.parseInt(monkeyNumber);
      } else if (line.contains("Starting items:")) {
        Matcher numberMatcher = numberPattern.matcher(line);
        List<BigInteger> startingItems = new ArrayList<>();
        while (numberMatcher.find()) {
          BigInteger number = new BigInteger(numberMatcher.group());
          startingItems.add(number);
        }
        monkeys.get(currentMonkey).setItems(startingItems);
      } else if (line.contains("Operation:")) {
        int firstIndex = line.indexOf("old");
        int secondIndex = line.indexOf("old" , firstIndex + "old".length());
        String value;
        if (secondIndex != -1) {
          value = "old";
        } else {
          Matcher numberMatcher = numberPattern.matcher(line);
          if (!numberMatcher.find()) {
            throw new RuntimeException("No integer found in the line.");
          }
          value = numberMatcher.group();
        }
        if (line.contains("*")) {
          monkeys.get(currentMonkey).setMultiplyOperation(value);
        } else if (line.contains("+")) {
          monkeys.get(currentMonkey).setAddOperation(value);
        } else {
          throw new RuntimeException("Unknown operation");
        }
      } else if (line.contains("Test:")) {
        String divisor = extractNumber(line);
        monkeys.get(currentMonkey).setDivisor(new BigInteger(divisor));
      } else if (line.contains("If true:")) {
        String trueMonkey = extractNumber(line);
        monkeys.get(currentMonkey).setTrueMonkey(Integer.parseInt(trueMonkey));
      } else if (line.contains("If false:")) {
        String falseMonkey = extractNumber(line);
        monkeys.get(currentMonkey).setFalseMonkey(Integer.parseInt(falseMonkey));
      }
    }
    return monkeys;
  }

  private static String extractNumber(String line) {
    Matcher numberMatcher = numberPattern.matcher(line);
    if (!numberMatcher.find()) {
      throw new RuntimeException("No integer found in the line.");
    }
    return numberMatcher.group();
  }
}
