package org.toyrobot.simulator.command;

import org.toyrobot.simulator.model.CommandTypeEnum;
import org.toyrobot.simulator.model.Position;

/**
 * Commands take an input getCoordinate and transform it to an output getCoordinate, based on their
 * respective implementation.
 */
public interface Command {

  /**
   * Transform an input getCoordinate.
   *
   * @param position The target position.
   * @return The updated Position.
   */
  Position executeCommand(Position position);

  CommandTypeEnum getCommandType();
}
