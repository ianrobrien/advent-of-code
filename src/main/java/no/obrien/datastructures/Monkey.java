package no.obrien.datastructures;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import lombok.Data;

@Data
public class Monkey {

  private List<Integer> items;
  private Function<Integer, Integer> operation;
  private int divisor;
  private int trueMonkey;
  private int falseMonkey;
  private int itemIndex = 0;
  private int inspectionCount = 0;

  public void inspectItems(List<Monkey> monkeys) {
    for (Integer item : items) {
      item = this.operation.apply(item);
      item = item / 3;
      int monkeyRecipient = item % divisor == 0 ? trueMonkey : falseMonkey;
      monkeys.get(monkeyRecipient).getItems().add(item);
      inspectionCount++;
    }
    items.clear();
  }

  public void setMultiplyOperation(String value) {
    if (Objects.equals(value, "old")) {
      this.operation = (Integer i) -> i * i;
    } else {
      this.operation = (Integer i) -> i * Integer.parseInt(value);
    }
  }

  public void setAddOperation(String value) {
    if (Objects.equals(value, "old")) {
      this.operation = (Integer i) -> i + i;
    } else {
      this.operation = (Integer i) -> i + Integer.parseInt(value);
    }
  }
}
