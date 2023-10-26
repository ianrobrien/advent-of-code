package no.obrien.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import no.obrien.twentytwo.RucksackReorganization;

@UtilityClass
@Slf4j
public class FileUtils {

  /***
   * Parse input file into a list of strings
   * @param inputFilePath path to input file
   * @return list of strings
   */
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

  /***
   * Parse input file into a list of strings, grouped by the number of groups
   * @param inputFilePath path to input file
   * @param groups number of groups
   * @return list of strings
   */
  public List<List<String>> parseInputFile(String inputFilePath, int groups) {
    if (groups < 1) {
      throw new IllegalArgumentException("Groups must be greater than 0");
    }
    var lines = parseInputFile(inputFilePath);
    return IntStream.range(0, lines.size())
        .boxed()
        .collect(Collectors.groupingBy(i -> i / groups))
        .values()
        .stream()
        .map(indices -> indices.stream()
            .map(lines::get)
            .collect(Collectors.toList()))
        .toList();
  }
}
