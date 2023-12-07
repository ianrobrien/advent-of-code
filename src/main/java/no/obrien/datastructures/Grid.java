package no.obrien.datastructures;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Grid<T> {

  private Map<Tuple<Integer>, T> grid = new LinkedHashMap<>();

  public int getMaxX() {
    return this.getRow(0).stream().mapToInt(Point::getX).max().orElse(0);
  }

  public int getMaxY() {
    return this.getColumn(0).stream().mapToInt(Point::getY).max().orElse(0);
  }

  public List<Point<T>> getRow(int rowIndex) {
    return grid.entrySet().stream()
        .filter(p -> p.getKey().getY() == rowIndex)
        .map(p -> new Point<>(p.getKey().getX(), p.getKey().getY(), p.getValue()))
        .toList();
  }

  public List<Point<T>> getColumn(int columnIndex) {
    return grid.entrySet().stream()
        .filter(p -> p.getKey().getX() == columnIndex)
        .map(p -> new Point<>(p.getKey().getX(), p.getKey().getY(), p.getValue()))
        .toList();
  }

  public void add(int x, int y, T value) {
    grid.put(new Tuple<>(x, y), value);
  }

  public T get(int x, int y) {
    return grid.getOrDefault(new Tuple<>(x, y), null);
  }

  public boolean contains(int x, int y) {
    return grid.containsKey(new Tuple<>(x, y));
  }

  public void remove(int x, int y) {
    grid.remove(new Tuple<>(x, y));
  }

  public T peekUp(int x, int y) {
    return grid.getOrDefault(new Tuple<>(x, y - 1), null);
  }

  public T peekDown(int x, int y) {
    return grid.getOrDefault(new Tuple<>(x, y + 1), null);
  }

  public T peekLeft(int x, int y) {
    return grid.getOrDefault(new Tuple<>(x - 1, y), null);
  }

  public T peekRight(int x, int y) {
    return grid.getOrDefault(new Tuple<>(x + 1, y), null);
  }

  public T peekUpLeft(int x, int y) {
    return grid.getOrDefault(new Tuple<>(x - 1, y - 1), null);
  }

  public T peekUpRight(int x, int y) {
    return grid.getOrDefault(new Tuple<>(x + 1, y + 1), null);
  }

  public T peekDownLeft(int x, int y) {
    return grid.getOrDefault(new Tuple<>(x - 1, y - 1), null);
  }

  public T peekDownRight(int x, int y) {
    return grid.getOrDefault(new Tuple<>(x + 1, y - 1), null);
  }
}
