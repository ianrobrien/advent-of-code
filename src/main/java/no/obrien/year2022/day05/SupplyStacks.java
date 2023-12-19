package no.obrien.year2022.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import no.obrien.utils.FileUtils;

@UtilityClass
public class SupplyStacks {

  public String partOne(String filePath) {
    var stacks = createStacks(FileUtils.parseInputFile(filePath));
    performMove(stacks, FileUtils.parseInputFile(filePath));
    return stacks.stream().map(Stack::pop).collect(Collectors.joining());
  }

  public String partTwo(String filePath) {
    var stacks = createStacks(FileUtils.parseInputFile(filePath));
    performMoveTwo(stacks, FileUtils.parseInputFile(filePath));
    return stacks.stream().map(Stack::pop).collect(Collectors.joining());
  }

  private List<Stack<String>> createStacks(List<String> state) {
    var stackLines = new ArrayList<String>();
    for (String line : state) {
      if (line.startsWith("[")) {
        stackLines.add(line);
      }
    }

    List<Stack<String>> stacks = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      stacks.add(new Stack<>());
    }
    assert (stacks.size() == 9);

    for (int i = stackLines.size(); i > 0; i--) {
      String plan = stackLines.get(i - 1);
      if (plan.length() >= 3) {
        String stack1 = plan.substring(1, 2);
        if (!stack1.isBlank()) {
          stacks.get(0).push(stack1);
        }
      }
      if (plan.length() >= 7) {
        String stack2 = plan.substring(5, 6);
        if (!stack2.isBlank()) {
          stacks.get(1).push(stack2);
        }
      }
      if (plan.length() >= 11) {
        String stack3 = plan.substring(9, 10);
        if (!stack3.isBlank()) {
          stacks.get(2).push(stack3);
        }
      }
      if (plan.length() >= 15) {
        String stack4 = plan.substring(13, 14);
        if (!stack4.isBlank()) {
          stacks.get(3).push(stack4);
        }
      }
      if (plan.length() >= 19) {
        String stack5 = plan.substring(17, 18);
        if (!stack5.isBlank()) {
          stacks.get(4).push(stack5);
        }
      }
      if (plan.length() >= 23) {
        String stack6 = plan.substring(21, 22);
        if (!stack6.isBlank()) {
          stacks.get(5).push(stack6);
        }
      }
      if (plan.length() >= 27) {
        String stack7 = plan.substring(25, 26);
        if (!stack7.isBlank()) {
          stacks.get(6).push(stack7);
        }
      }
      if (plan.length() >= 31) {
        String stack8 = plan.substring(29, 30);
        if (!stack8.isBlank()) {
          stacks.get(7).push(stack8);
        }
      }
      if (plan.length() >= 35) {
        String stack9 = plan.substring(33, 34);
        if (!stack9.isBlank()) {
          stacks.get(8).push(stack9);
        }
      }
    }
    return stacks;
  }

  private void performMove(List<Stack<String>> stacks, List<String> instructions) {
    for (String instruction : instructions) {
      if (instruction.startsWith("move")) {
        int amount = getAmount(instruction);
        int sourceStack = getSourceStack(instruction);
        int destinationStack = getDestinationStack(instruction);

        int i = 0;
        while (i < amount) {
          stacks.get(destinationStack - 1).push(stacks.get(sourceStack - 1).pop());
          i++;
        }
      }
    }
  }

  private void performMoveTwo(List<Stack<String>> stacks, List<String> instructions) {
    for (String instruction : instructions) {
      if (instruction.startsWith("move")) {
        int amount = getAmount(instruction);
        int sourceStack = getSourceStack(instruction);
        int destinationStack = getDestinationStack(instruction);

        int i = 0;
        Stack<String> temp = new Stack<>();
        while (i < amount) {
          if (amount == 1) {
            stacks.get(destinationStack - 1).push(stacks.get(sourceStack - 1).pop());
          } else {
            temp.push(stacks.get(sourceStack - 1).pop());
          }
          i++;
        }
        while (!temp.isEmpty()) {
          stacks.get(destinationStack - 1).push(temp.pop());
        }
      }
    }
  }

  private static int getDestinationStack(String instruction) {
    return Integer.parseInt(
        instruction.substring(instruction.indexOf("to") + 2).trim());
  }

  private static int getSourceStack(String instruction) {
    return Integer.parseInt(
        instruction.substring(
            instruction.indexOf("from") + 4,
            instruction.indexOf("to")).trim());
  }

  private static int getAmount(String instruction) {
    return Integer.parseInt(instruction.substring(5, instruction.indexOf("from")).trim());
  }
}