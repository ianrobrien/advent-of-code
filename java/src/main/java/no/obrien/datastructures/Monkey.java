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
  private int divisor;
  private int trueMonkey;
  private int falseMonkey;
  private int itemIndex = 0;
  private long inspectionCount = 0;

  public void inspectItems(List<Monkey> monkeys, int worryLevel, int commonMultiplier) {
    for (Long item : items) {
      var value = this.operation.apply(item) / worryLevel % commonMultiplier;
      int monkeyRecipient = value % divisor == 0 ? trueMonkey : falseMonkey;
      monkeys.get(monkeyRecipient).getItems().add(value);
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
