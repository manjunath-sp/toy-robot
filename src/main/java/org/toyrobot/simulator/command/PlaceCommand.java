package org.toyrobot.simulator.command;

import org.toyrobot.simulator.model.CommandTypeEnum;
import org.toyrobot.simulator.model.Position;

/**
 * The place command will output the getCoordinate provided in the constructor, no matter what the
 * input was.
 */
public class PlaceCommand implements Command {

  private final Position position;

  public PlaceCommand(Position position) {
    this.position = position;
  }

  @Override
  public Position executeCommand(Position position) {
    return this.position;
  }

  @Override
  public CommandTypeEnum getCommandType() {
    return CommandTypeEnum.PLACE;
  }
}
