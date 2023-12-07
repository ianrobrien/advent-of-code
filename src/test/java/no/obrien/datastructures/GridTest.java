package no.obrien.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GridTest {

  @Test
  void getMaxX() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(1, 0, 1);
    grid.add(2, 0, 1);

    assertEquals(2, grid.getMaxX());
  }

  @Test
  void getMaxY() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(0, 1, 1);
    grid.add(0, 2, 1);

    assertEquals(2, grid.getMaxY());
  }

  @Test
  void getRow() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(1, 0, 1);
    grid.add(2, 0, 1);

    assertEquals(3, grid.getRow(0).size());
  }

  @Test
  void getColumn() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(0, 1, 1);
    grid.add(0, 2, 1);

    assertEquals(3, grid.getColumn(0).size());
  }

  @Test
  void add() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    assertEquals(1, grid.getRow(0).size());
    assertEquals(1, grid.getColumn(0).size());
  }

  @Test
  void get() {
    var grid = new Grid<Integer>();
    grid.add(5, 5, 5);

    assertEquals(5, grid.get(5, 5));
  }

  @Test
  void contains() {
    var grid = new Grid<Integer>();
    grid.add(5, 5, 5);

    assertTrue(grid.contains(5, 5));
    assertFalse(grid.contains(5, 3));
  }

  @Test
  void remove() {
    var grid = new Grid<Integer>();
    grid.add(5, 5, 5);
    grid.remove(5, 5);
    assertEquals(0, grid.getRow(5).size());
  }

  @Test
  void peekUp() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(0, 1, 2);

    assertEquals(1, grid.peekUp(0, 1));
  }

  @Test
  void peekDown() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(0, 1, 2);

    assertEquals(2, grid.peekDown(0, 0));
  }

  @Test
  void peekLeft() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(1, 0, 2);

    assertEquals(1, grid.peekLeft(1, 0));
  }

  @Test
  void peekRight() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(1, 0, 2);

    assertEquals(2, grid.peekRight(0, 0));
  }

  @Test
  void peekUpLeft() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(1, 1, 2);

    assertEquals(1, grid.peekUpLeft(1, 1));
  }

  @Test
  void peekUpRight() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(1, 1, 2);

    assertEquals(2, grid.peekUpRight(0, 0));
  }

  @Test
  void peekDownLeft() {
    var grid = new Grid<Integer>();
    grid.add(0, 0, 1);
    grid.add(1, 1, 2);

    assertEquals(1, grid.peekDownLeft(1, 1));
  }

  @Test
  void peekDownRight() {
    var grid = new Grid<Integer>();
    grid.add(2, 0, 1);
    grid.add(1, 1, 2);

    assertEquals(1, grid.peekDownRight(1, 1));
  }
}