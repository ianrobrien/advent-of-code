package no.obrien.year2022.day08;

import java.util.List;
import lombok.experimental.UtilityClass;
import no.obrien.utils.FileUtils;

@UtilityClass
public class TreetopTreeHouse {

  public int partOne(String inputFilePath) {
    var lines = FileUtils.parseInputFile(inputFilePath);
    var forest = createForest(lines);
    return countVisibleTrees(forest);
  }

  public int partTwo(String inputFilePath) {
    var lines = FileUtils.parseInputFile(inputFilePath);
    var forest = createForest(lines);
    return calculateScenicScore(forest);
  }

  private int countVisibleTrees(int[][] forest) {
    int visibleTrees = 0;

    for (int row = 0; row < forest.length; row++) {
      for (int column = 0; column < forest[0].length; column++) {
        if (isEdgeTree(forest, row, column)
            || isVisibleUp(forest, row, column)
            || isVisibleDown(forest, row, column)
            || isVisibleLeft(forest, row, column)
            || isVisibleRight(forest, row, column)) {
          visibleTrees++;
        }
      }
    }

    return visibleTrees;
  }

  private static boolean isEdgeTree(int[][] forest, int row, int column) {
    return row == 0
        || column == 0
        || row == forest.length - 1
        || column == forest[0].length - 1;
  }

  public boolean isVisibleUp(int[][] forest, int row, int column) {
    int height = forest[row][column];
    for (int i = row - 1; i >= 0; i--) {
      if (forest[i][column] >= height) {
        return false;
      }
    }
    return true;
  }

  public boolean isVisibleDown(int[][] forest, int row, int column) {
    int height = forest[row][column];
    for (int i = row + 1; i <= forest.length - 1; i++) {
      if (forest[i][column] >= height) {
        return false;
      }
    }
    return true;
  }

  public boolean isVisibleLeft(int[][] forest, int row, int column) {
    int height = forest[row][column];
    for (int i = column - 1; i >= 0; i--) {
      if (forest[row][i] >= height) {
        return false;
      }
    }
    return true;
  }

  public boolean isVisibleRight(int[][] forest, int row, int column) {
    int height = forest[row][column];
    for (int i = column + 1; i <= forest[0].length - 1; i++) {
      if (forest[row][i] >= height) {
        return false;
      }
    }
    return true;
  }

  private int calculateScenicScore(int[][] forest) {
    int maxScenicScore = -1;
    for (int row = 0; row < forest.length; row++) {
      for (int column = 0; column < forest[0].length; column++) {
        if (!isEdgeTree(forest, row, column)) {
          int up = calculateScenicScoreUp(forest, row, column);
          int left = calculateScenicScoreLeft(forest, row, column);
          int down = calculateScenicScoreDown(forest, row, column);
          int right = calculateScenicScoreRight(forest, row, column);
          int scenicScore = up * left * down * right;
          maxScenicScore = Math.max(maxScenicScore, scenicScore);
        }
      }
    }
    return maxScenicScore;
  }

  private int calculateScenicScoreUp(int[][] forest, int row, int column) {
    int height = forest[row][column];
    int scenicScore = 1;
    for (int i = row - 1; i >= 0; i--) {
      if (forest[i][column] >= height) {
        return scenicScore;
      }
      scenicScore++;
    }
    return scenicScore;
  }

  private int calculateScenicScoreLeft(int[][] forest, int row, int column) {
    int height = forest[row][column];
    int scenicScore = 1;
    for (int i = column - 1; i >= 0; i--) {
      if (forest[row][i] >= height) {
        return scenicScore;
      }
      if (i != 0) {
        scenicScore++;
      }
    }
    return scenicScore;
  }

  private int calculateScenicScoreDown(int[][] forest, int row, int column) {
    int height = forest[row][column];
    int scenicScore = 1;
    for (int i = row + 1; i <= forest.length - 1; i++) {
      if (forest[i][column] >= height) {
        return scenicScore;
      }
      if (i != forest.length - 1) {
        scenicScore++;
      }
    }
    return scenicScore;
  }

  private int calculateScenicScoreRight(int[][] forest, int row, int column) {
    int height = forest[row][column];
    int scenicScore = 1;
    for (int i = column + 1; i <= forest[0].length - 1; i++) {
      if (forest[row][i] >= height) {
        return scenicScore;
      }
      if (i != forest[0].length - 1) {
        scenicScore++;
      }
    }
    return scenicScore;
  }

  private int[][] createForest(List<String> trees) {
    int[][] forest = new int[trees.get(0).length()][trees.size()];
    for (int i = 0; i < trees.size(); i++) {
      String line = trees.get(i);
      for (int j = 0; j < line.length(); j++) {
        String tree = line.substring(j, j + 1);
        forest[i][j] = Integer.parseInt(tree);
      }
    }
    return forest;
  }
}
