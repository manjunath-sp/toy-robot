package org.toyrobot.simulator.command;

import java.util.logging.Logger;
import org.toyrobot.simulator.model.CommandTypeEnum;
import org.toyrobot.simulator.model.Position;

/**
 * This will move the toy robot one unit forward in the direction it is currently facing.
 */
public class MoveCommand implements Command {

  private static final Logger LOGGER = Logger.getLogger(MoveCommand.class.getName());

  @Override
  public Position executeCommand(Position position) {
    if (position.getDirection() != null) {
      switch (position.getDirection()) {
        case NORTH:
          return new Position(position.getCoordinate().getX(),
              position.getCoordinate().getY() + 1,
              position.getDirection());
        case EAST:
          return new Position(position.getCoordinate().getX() + 1,
              position.getCoordinate().getY(),
              position.getDirection());
        case SOUTH:
          return new Position(position.getCoordinate().getX(),
              position.getCoordinate().getY() - 1,
              position.getDirection());
        case WEST:
          return new Position(position.getCoordinate().getX() - 1,
              position.getCoordinate().getY(),
              position.getDirection());
        default:
          LOGGER.warning("Direction unknown: " + position.getDirection() + ", will not move.");
          return position;
      }
    }
    return null;
  }

  @Override
  public CommandTypeEnum getCommandType() {
    return CommandTypeEnum.MOVE;
  }
}
