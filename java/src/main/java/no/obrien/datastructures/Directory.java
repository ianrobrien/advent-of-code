package no.obrien.datastructures;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"children", "files", "parent"})
public class Directory {

  private final String name;
  private final Map<String, Directory> children;
  private final Map<String, Integer> files;
  private final Directory parent;
  private long size;

  public Directory(String name) {
    this(name, null);
  }

  public Directory(String name, Directory parent) {
    this.name = name;
    this.children = new HashMap<>();
    this.files = new HashMap<>();
    this.parent = parent;
    this.size = 0;
  }
}
