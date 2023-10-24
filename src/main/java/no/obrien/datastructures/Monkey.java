package no.obrien.datastructures;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Monkey {

  private List<Long> items;
  private Function<Long, Long> operation;
  private Long divisor;
  private int trueMonkey;
  private int falseMonkey;
  private int itemIndex = 0;
  private int inspectionCount = 0;

  public void inspectItems(List<Monkey> monkeys, int worryLevel) {
    for (Long item : items) {
      item = this.operation.apply(item);
      if (worryLevel > 1) {
        item = item / worryLevel;
      }
      int monkeyRecipient = item % divisor == 0 ? trueMonkey : falseMonkey;
      monkeys.get(monkeyRecipient).getItems().add(item);
      inspectionCount++;
    }
    items.clear();
  }

  public void setMultiplyOperation(String value) {
    if (Objects.equals(value, "old")) {
      this.operation = (Long i) -> i * i;
    } else {
      this.operation = (Long i) -> i * Long.parseLong(value);
    }
  }

  public void setAddOperation(String value) {
    if (Objects.equals(value, "old")) {
      this.operation = (Long i) -> i + i;
    } else {
      this.operation = (Long i) -> i + Long.parseLong(value);
    }
  }
}
