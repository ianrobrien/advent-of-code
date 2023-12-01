package no.obrien.twentythree;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.experimental.UtilityClass;
import no.obrien.utils.FileUtils;

@UtilityClass
public class Trebuchet {

  public int partOne(String filePath) {
    var result = new AtomicInteger();
    FileUtils.parseInputFile(filePath).forEach(line -> {
      String firstDigit = "";
      for (int i = 0; i < line.length(); i++) {
        if (Character.isDigit(line.charAt(i))) {
          firstDigit = String.valueOf(line.charAt(i));
          break;
        }
      }

      String lastDigit = "";
      for (int i = line.length() - 1; i >= 0; i--) {
        if (Character.isDigit(line.charAt(i))) {
          lastDigit = String.valueOf(line.charAt(i));
          break;
        }
      }

      result.addAndGet(Integer.parseInt(firstDigit + lastDigit));
    });
    return result.get();
  }
}
