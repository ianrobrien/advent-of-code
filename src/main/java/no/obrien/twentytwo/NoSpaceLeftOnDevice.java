package no.obrien.twentytwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.UtilityClass;
import no.obrien.datastructures.Directory;
import no.obrien.utils.FileUtils;

@UtilityClass
public class NoSpaceLeftOnDevice {

  public long partOne(String inputFilePath) {
    var lines = FileUtils.parseInputFile(inputFilePath);
    final var root = createDirectorySystem(lines);
    return calculateSizePartOne(root);
  }

  public long partTwo(String inputFilePath) {
    var lines = FileUtils.parseInputFile(inputFilePath);
    final var root = createDirectorySystem(lines);
    long totalDiskSpace = 70000000;
    long requiredDiskSpace = 30000000;
    long spaceToFree = requiredDiskSpace - (totalDiskSpace - root.getSize());

    var directories = new ArrayList<Directory>();
    walkFileTree(root, directories);

    return directories.stream()
        .map(Directory::getSize)
        .filter(directory -> directory > spaceToFree)
        .sorted()
        .findFirst()
        .orElseThrow();
  }

  private void walkFileTree(Directory root, List<Directory> directories) {
    if (!root.getChildren().isEmpty()) {
      for (Directory child : root.getChildren().values()) {
        directories.add(child);
        walkFileTree(child, directories);
      }
    }
  }

  private long calculateSizePartOne(Directory directory) {
    long size = directory.getSize() < 100000 ? directory.getSize() : 0;
    if (!directory.getChildren().isEmpty()) {
      for (Directory child : directory.getChildren().values()) {
        size += calculateSizePartOne(child);
      }
    }
    return size;
  }

  private Directory createDirectorySystem(List<String> lines) {
    final var root = new Directory("/");
    var currentDirectory = root;
    for (String line : lines) {
      if (!line.isBlank()) {
        if (line.startsWith("$")) {
          currentDirectory = navigate(line, currentDirectory, root);
        } else if (line.startsWith("dir")) {
          addDirectory(line, currentDirectory);
        } else {
          addFile(line, currentDirectory);
        }
      }
    }
    return root;
  }

  private static Directory navigate(String line, Directory currentDirectory, Directory root) {
    if (line.equals("$ cd /")) {
      currentDirectory = root;
    } else if (line.contains("cd")) {
      String directoryName = line.substring(4).trim();
      if (directoryName.equals("..")) {
        currentDirectory = currentDirectory.getParent();
      } else {
        currentDirectory = currentDirectory.getChildren().get(directoryName);
      }
    }
    return currentDirectory;
  }

  private static void addDirectory(String line, Directory currentDirectory) {
    String directoryName = line.substring(4).trim();
    currentDirectory.getChildren()
        .put(directoryName, new Directory(directoryName, currentDirectory));
  }

  private static void addFile(String line, Directory currentDirectory) {
    String fileName = line.split(" ")[1].trim();
    int fileSize = Integer.parseInt(line.split(" ")[0].trim());
    currentDirectory.getFiles().put(fileName, fileSize);
    currentDirectory.setSize(currentDirectory.getSize() + fileSize);

    var parent = currentDirectory.getParent();
    while (parent != null) {
      parent.setSize(parent.getSize() + fileSize);
      parent = parent.getParent();
    }
  }
}
