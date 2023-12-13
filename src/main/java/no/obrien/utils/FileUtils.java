package no.obrien.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import no.obrien.twentytwo.day03.RucksackReorganization;

@UtilityClass
@Slf4j
public class FileUtils {

  public List<String> parseInputFile(String inputFilePath) {
    var items = new ArrayList<String>();
    try (InputStream inputStream = RucksackReorganization.class.getClassLoader()
        .getResourceAsStream(inputFilePath)) {
      if (inputStream != null) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
          String line;
          while ((line = reader.readLine()) != null) {
            items.add(line);
          }
        } catch (IOException e) {
          log.error(e.getMessage());
        }
      }
      return items;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
