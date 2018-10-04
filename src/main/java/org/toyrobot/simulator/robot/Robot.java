package org.toyrobot.simulator.robot;

import java.util.List;
import org.toyrobot.simulator.command.Command;
import org.toyrobot.simulator.model.Position;

/**
 * A robot for the toy robot simulator challenge.
 */
public interface Robot {

  /**
   * List of command to the robot. It reports the position and with repect to the command
   *
   * @param commands The commands the robot should execute.
   * @return an ordered Map of Position to CommandType.
   */
  List<Position> executeCommandsAndReportPositions(List<Command> commands);

}
