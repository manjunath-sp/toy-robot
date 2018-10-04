package org.toyrobot.simulator.robot.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.toyrobot.simulator.command.Command;
import org.toyrobot.simulator.model.CommandTypeEnum;
import org.toyrobot.simulator.model.Coordinate;
import org.toyrobot.simulator.model.Position;
import org.toyrobot.simulator.robot.Robot;

/**
 * Implementation class for Robot
 */
public class RobotImpl implements Robot {

  private static final Logger LOGGER = Logger.getLogger(RobotImpl.class.getName());

  private final Coordinate boundary;

  public RobotImpl(Coordinate boundary) {
    this.boundary = boundary;
  }

  @Override
  public List<Position> executeCommandsAndReportPositions(List<Command> commands) {

    List<Position> reportPositions = new ArrayList<>();
    Position position = null;
    for (Command command : commands) {
      Position newPosition = command.executeCommand(position);
      if (this.isValidPosition(newPosition)) {
        if (LOGGER.isLoggable(Level.FINE)) {
          LOGGER.log(Level.FINE, newPosition.toString());
        }
        if (CommandTypeEnum.REPORT.equals(command.getCommandType())) {
          reportPositions.add(newPosition);
        }
        position = newPosition;
      }
    }
    return reportPositions;
  }

  private boolean isValidPosition(Position position) {

    if (position == null || position.getCoordinate() == null) {
      return false;
    }

    Coordinate coordinate = position.getCoordinate();
    return coordinate.getX() >= 0 &&
        coordinate.getY() >= 0 &&
        coordinate.getX() < this.boundary.getX() &&
        coordinate.getY() < this.boundary.getY();
  }

}
