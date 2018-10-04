package org.toyrobot.simulator.model;

import java.util.Objects;

/**
 * Immutable data object representing a coordinate and an direction.
 */
public class Position {

  private final DirectionEnum direction;
  private final Coordinate coordinate;

  public Position(final int x, final int y, final DirectionEnum direction) {
    this.direction = direction;
    this.coordinate = new Coordinate(x, y);
  }

  public Position(final Coordinate coordinate, final DirectionEnum direction) {
    this.direction = direction;
    this.coordinate = coordinate;
  }

  public DirectionEnum getDirection() {
    return this.direction;
  }

  public Coordinate getCoordinate() {
    return this.coordinate;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Position)) {
      return false;
    }
    final Position position = (Position) o;
    return this.direction == position.direction &&
        Objects.equals(this.coordinate, position.coordinate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.direction, this.coordinate);
  }

  @Override
  public String toString() {
    return String
        .format("%d,%d,%s", this.coordinate.getX(), this.coordinate.getY(), this.direction);
  }
}
