package no.obrien.datastructures;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Monkey {

  private List<BigInteger> items;
  private Function<BigInteger, BigInteger> operation;
  private BigInteger divisor;
  private int trueMonkey;
  private int falseMonkey;
  private int itemIndex = 0;
  private int inspectionCount = 0;
  private final BigInteger worryLevel;

  public void inspectItems(List<Monkey> monkeys) {
    for (BigInteger item : items) {
      item = this.operation.apply(item);
      item = item.divide(worryLevel);
      boolean isDivisible = item.remainder(divisor).equals(BigInteger.ZERO);
      int monkeyRecipient = isDivisible ? trueMonkey : falseMonkey;
      monkeys.get(monkeyRecipient).getItems().add(item);
      inspectionCount++;
    }
    items.clear();
  }

  public void setMultiplyOperation(String value) {
    if (Objects.equals(value, "old")) {
      this.operation = (BigInteger i) -> i.multiply(i);
    } else {
      this.operation = (BigInteger i) -> i.multiply(new BigInteger(value));
    }
  }

  public void setAddOperation(String value) {
    if (Objects.equals(value, "old")) {
      this.operation = (BigInteger i) -> i.add(i);
    } else {
      this.operation = (BigInteger i) -> i.add(new BigInteger(value));
    }
  }
}
