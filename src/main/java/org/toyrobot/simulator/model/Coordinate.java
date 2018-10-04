package org.toyrobot.simulator.model;

import java.util.Objects;

/**
 * POJO to represent getX and getY coordinates.
 */
public class Coordinate {

  private final int x;
  private final int y;

  public Coordinate(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Coordinate)) {
      return false;
    }
    final Coordinate that = (Coordinate) o;
    return this.x == that.x &&
        this.y == that.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }

  @Override
  public String toString() {
    return "Coordinate{" +
        "x=" + this.x +
        ", y=" + this.y +
        '}';
  }
}
