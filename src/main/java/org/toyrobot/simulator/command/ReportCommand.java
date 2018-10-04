package org.toyrobot.simulator.command;

import org.toyrobot.simulator.model.CommandTypeEnum;
import org.toyrobot.simulator.model.Position;

/**
 * REPORT will announce the X, Y and F of the robot - this can be in any form, but standard output
 * is sufficient.
 */
public class ReportCommand implements Command {

  @Override
  public Position executeCommand(Position position) {
    return position;
  }

  @Override
  public CommandTypeEnum getCommandType() {
    return CommandTypeEnum.REPORT;
  }
}
