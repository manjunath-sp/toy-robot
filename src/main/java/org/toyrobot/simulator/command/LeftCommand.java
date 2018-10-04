package org.toyrobot.simulator.command;

import org.toyrobot.simulator.model.CommandTypeEnum;
import org.toyrobot.simulator.model.Position;

/**
 * LEFT will rotate the robot 90 degrees in the specified direction without changing the position of
 * the robot.
 */
public class LeftCommand implements Command {

  @Override
  public Position executeCommand(Position position) {
    if (position == null) {
      return null;
    }
    return new Position(position.getCoordinate(), position.getDirection().left());
  }

  @Override
  public CommandTypeEnum getCommandType() {
    return CommandTypeEnum.LEFT;
  }
}
