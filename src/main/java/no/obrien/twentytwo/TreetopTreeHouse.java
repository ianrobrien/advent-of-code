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

    for (int i = 0; i < forest.length; i++) {
      for (int j = 0; j < forest.length; j++) {
        if (i == 0 || j == 0 || i == forest.length - 1 || j == forest.length - 1) {
          visibleTrees++;
        } else if (checkXandY(forest, i, j)) {
          visibleTrees++;
        }
      }
    }

    return visibleTrees;
  }

  private boolean checkXandY(int[][] forest, int x, int y) {
    // check positive x
    int tree = forest[x][y];
    boolean visible = true;
    for (int i = 0; i < x; i++) {
      if (forest[i][y] >= tree) {
        visible = false;
        break;
      }
    }
    if (visible) {
      return true;
    }
    // check negative x
    visible = true;
    for (int i = x; i < forest.length; i++) {
      if (forest[i][y] >= tree) {
        visible = false;
        break;
      }
    }
    if (visible) {
      return true;
    }
    // check positive y
    visible = true;
    for (int i = 0; i < y; i++) {
      if (forest[x][i] >= tree) {
        visible = false;
        break;
      }
    }
    if (visible) {
      return true;
    }
    // check negative y
    visible = true;
    for (int i = y; i < forest.length; i++) {
      if (forest[x][i] >= tree) {
        visible = false;
        break;
      }
    }
    return visible;
  }

  private int[][] createForest(List<String> trees) {
    int[][] forest = new int[5][5];

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
