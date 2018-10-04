package org.toyrobot.simulator.command;

import org.toyrobot.simulator.model.CommandTypeEnum;
import org.toyrobot.simulator.model.Position;

/**
 * Handle null commands or invalid commands
 */
public class NullCommand implements Command {

  @Override
  public Position executeCommand(Position position) {
    return position;
  }

  @Override
  public CommandTypeEnum getCommandType() {
    return CommandTypeEnum.INVALID;
  }
}
