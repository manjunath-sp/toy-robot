package org.toyrobot.simulator.model;

/**
 * Enum representing the possible directions of the Robot.
 */
public enum DirectionEnum {

  EAST,
  NORTH,
  SOUTH,
  WEST;

  public DirectionEnum left() {
    return this.getDirection(WEST, NORTH, EAST, SOUTH);
  }

  public DirectionEnum right() {
    return this.getDirection(EAST, SOUTH, WEST, NORTH);
  }

  private DirectionEnum getDirection(
      final DirectionEnum caseNorth, final DirectionEnum caseEast, final DirectionEnum caseSouth,
      final DirectionEnum caseWest) {
    switch (this) {
      case NORTH:
        return caseNorth;
      case EAST:
        return caseEast;
      case SOUTH:
        return caseSouth;
      case WEST:
        return caseWest;
      default:
        throw new IllegalStateException("Direction unknown: " + this);
    }
  }
}
