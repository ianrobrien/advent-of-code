package no.obrien.twentytwo;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import no.obrien.datastructures.Tuple;
import no.obrien.utils.FileUtils;

@UtilityClass
@Slf4j
public class RockPaperScissors {

  @RequiredArgsConstructor
  @Getter
  private enum OutcomeScore {
    WIN(6),
    DRAW(3),
    LOSS(0);

    private final int value;
  }

  @RequiredArgsConstructor
  @Getter
  private enum ChoiceScore {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int value;
  }

  public int partOne(String filePath) {
    return parseInputFile(filePath)
        .stream()
        .map(character ->
            calculateRoundScorePartOne(
                character.getFirst().toString(),
                character.getSecond().toString()))
        .mapToInt(Integer::intValue)
        .sum();
  }

  public int partTwo(String filePath) {
    return parseInputFile(filePath)
        .stream()
        .map(character ->
            calculateRoundScorePartTwo(
                character.getFirst().toString(),
                character.getSecond().toString()))
        .mapToInt(Integer::intValue)
        .sum();
  }

  private int calculateRoundScorePartOne(String opponent, String player) {
    return switch (opponent) {
      // ROCK
      case "A" -> switch (player) {
        // ROCK
        case "X" -> ChoiceScore.ROCK.getValue() + OutcomeScore.DRAW.getValue();
        // PAPER
        case "Y" -> ChoiceScore.PAPER.getValue() + OutcomeScore.WIN.getValue();
        // SCISSORS
        case "Z" -> ChoiceScore.SCISSORS.getValue() + OutcomeScore.LOSS.getValue();
        default -> 0;
      };
      // PAPER
      case "B" -> switch (player) {
        // ROCK
        case "X" -> ChoiceScore.ROCK.getValue() + OutcomeScore.LOSS.getValue();
        // PAPER
        case "Y" -> ChoiceScore.PAPER.getValue() + OutcomeScore.DRAW.getValue();
        // SCISSORS
        case "Z" -> ChoiceScore.SCISSORS.getValue() + OutcomeScore.WIN.getValue();
        default -> 0;
      };
      // SCISSORS
      case "C" -> switch (player) {
        // ROCK
        case "X" -> ChoiceScore.ROCK.getValue() + OutcomeScore.WIN.getValue();
        // PAPER
        case "Y" -> ChoiceScore.PAPER.getValue() + OutcomeScore.LOSS.getValue();
        // SCISSORS
        case "Z" -> ChoiceScore.SCISSORS.getValue() + OutcomeScore.DRAW.getValue();
        default -> 0;
      };
      default -> 0;
    };
  }

  private int calculateRoundScorePartTwo(String opponent, String player) {
    return switch (player) {
      // LOSE
      case "X" -> switch (opponent) {
        // ROCK
        case "A" -> ChoiceScore.SCISSORS.getValue() + OutcomeScore.LOSS.getValue();
        // PAPER
        case "B" -> ChoiceScore.ROCK.getValue() + OutcomeScore.LOSS.getValue();
        // SCISSORS
        case "C" -> ChoiceScore.PAPER.getValue() + OutcomeScore.LOSS.getValue();
        default -> 0;
      };
      // DRAW
      case "Y" -> switch (opponent) {
        // ROCK
        case "A" -> ChoiceScore.ROCK.getValue() + OutcomeScore.DRAW.getValue();
        // PAPER
        case "B" -> ChoiceScore.PAPER.getValue() + OutcomeScore.DRAW.getValue();
        // SCISSORS
        case "C" -> ChoiceScore.SCISSORS.getValue() + OutcomeScore.DRAW.getValue();
        default -> 0;
      };
      // WIN
      case "Z" -> switch (opponent) {
        // ROCK
        case "A" -> ChoiceScore.PAPER.getValue() + OutcomeScore.WIN.getValue();
        // PAPER
        case "B" -> ChoiceScore.SCISSORS.getValue() + OutcomeScore.WIN.getValue();
        // SCISSORS
        case "C" -> ChoiceScore.ROCK.getValue() + OutcomeScore.WIN.getValue();
        default -> 0;
      };
      default -> 0;
    };
  }

  private List<Tuple<Character>> parseInputFile(String filePath) {
    return FileUtils.parseInputFile(filePath)
        .stream()
        .map(line -> {
          var tokens = line.split(" ");
          return new Tuple<>(tokens[0].charAt(0), tokens[1].charAt(0));
        })
        .collect(Collectors.toList());
  }
}
