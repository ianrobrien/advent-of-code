package no.obrien.twentytwo;

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

  private int countVisibleTrees(int[][] forest) {
    int visibleTrees = 0;

    for (int row = 0; row < forest.length; row++) {
      for (int column = 0; column < forest[0].length; column++) {
        if (isEdgeTree(forest, row, column)
            || isVisibleUp(forest, row, column)
            || isVisibleDown(forest, row, column)
            || isVisibleLeft(forest, row, column)
            || isVisibleRight(forest, row, column)
        ) {
          visibleTrees++;
        }
      }
    }

    return visibleTrees;
  }

  private static boolean isEdgeTree(int[][] forest, int row, int column) {
    boolean edgeTree =
        row == 0 || column == 0 || row == forest.length - 1 || column == forest[0].length - 1;
    if (edgeTree) {
      System.out.println("Tree at " + row + ", " + column + " is on the edge");
      return true;
    }
    return false;
  }

  public boolean isVisibleUp(int[][] forest, int row, int column) {
    int height = forest[row][column];
    for (int i = row - 1; i >= 0; i--) {
      if (forest[i][column] >= height) {
        return false;
      }
    }

    System.out.println("Tree at " + row + ", " + column + " is visible up");
    return true;
  }

  public boolean isVisibleDown(int[][] forest, int row, int column) {
    int height = forest[row][column];
    for (int i = row + 1; i <= forest.length - 1; i++) {
      if (forest[i][column] >= height) {
        return false;
      }
    }

    System.out.println("Tree at " + row + ", " + column + " is visible down");
    return true;
  }

  public boolean isVisibleLeft(int[][] forest, int row, int column) {
    int height = forest[row][column];
    for (int i = column - 1; i >= 0; i--) {
      if (forest[row][i] >= height) {
        return false;
      }
    }

    System.out.println("Tree at " + row + ", " + column + " is visible left");
    return true;
  }

  public boolean isVisibleRight(int[][] forest, int row, int column) {
    int height = forest[row][column];
    for (int i = column + 1; i <= forest[0].length - 1; i++) {
      if (forest[row][i] >= height) {
        return false;
      }
    }

    System.out.println("Tree at " + row + ", " + column + " is visible right");
    return true;
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
