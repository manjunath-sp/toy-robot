package org.toyrobot.simulator.command.parser.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.toyrobot.simulator.command.Command;
import org.toyrobot.simulator.command.LeftCommand;
import org.toyrobot.simulator.command.MoveCommand;
import org.toyrobot.simulator.command.NullCommand;
import org.toyrobot.simulator.command.PlaceCommand;
import org.toyrobot.simulator.command.ReportCommand;
import org.toyrobot.simulator.command.RightCommand;
import org.toyrobot.simulator.model.CommandTypeEnum;
import org.toyrobot.simulator.model.DirectionEnum;
import org.toyrobot.simulator.model.Position;

/**
 * Converts a command string read from the input source into a {@link Command} object.
 */
class CommandParserHelper {

  private static final Logger LOGGER = Logger.getLogger(CommandParserHelper.class.getName());

  private static final Pattern PLACE_COMMAND_REGEX = Pattern
      .compile(CommandTypeEnum.PLACE.toString() + " (\\d+),(\\d+),(\\w+)");

  private CommandParserHelper() {
  }

  /**
   * Turn an input command string into a command object.
   *
   * @param commandString The command in string form.
   * @return The corresponding command object or a null-command in a fault case.
   */
  static Command parseCommand(String commandString) {
    if (commandString == null || commandString.isEmpty()) {
      LOGGER.log(Level.WARNING, "Empty command");
      return new NullCommand();
    }
    String formattedString = commandString.trim().toUpperCase();
    if (formattedString.equals(CommandTypeEnum.LEFT.toString())) {
      return new LeftCommand();
    } else if (formattedString.equals(CommandTypeEnum.MOVE.toString())) {
      return new MoveCommand();
    } else if (formattedString.startsWith(CommandTypeEnum.PLACE.toString())) {
      return CommandParserHelper.parsePlaceCommand(formattedString);
    } else if (formattedString.equals(CommandTypeEnum.REPORT.toString())) {
      return new ReportCommand();
    } else if (formattedString.equals(CommandTypeEnum.RIGHT.toString())) {
      return new RightCommand();
    } else {
      if (LOGGER.isLoggable(Level.WARNING)) {
        LOGGER.log(Level.WARNING, String.format("Invalid command: %s ignored.", formattedString));
      }
      return new NullCommand();
    }
  }

  private static Command parsePlaceCommand(String commandString) {
    Matcher matcher = PLACE_COMMAND_REGEX.matcher(commandString);
    if (matcher.matches()) {
      return CommandParserHelper.createPlaceCommand(matcher);
    } else {
      if (LOGGER.isLoggable(Level.WARNING)) {
        LOGGER.log(Level.WARNING, String.format("Invalid command: %s ignored.", commandString));
      }
      return new NullCommand();
    }
  }

  private static Command createPlaceCommand(Matcher matcher) {
    try {
      Position position = new Position(Integer.parseInt(matcher.group(1)),
          Integer.parseInt(matcher.group(2)),
          CommandParserHelper.parsePlaceCommandDirection(matcher.group(3)));

      return new PlaceCommand(position);
    } catch (IllegalArgumentException e) {
      LOGGER.log(Level.WARNING, e.getMessage());
      return new NullCommand();
    }
  }

  private static DirectionEnum parsePlaceCommandDirection(String orientationString) {
    if (orientationString == null || orientationString.isEmpty()) {
      throw new IllegalArgumentException("No direction specified");
    } else if (orientationString.equals(DirectionEnum.NORTH.toString())) {
      return DirectionEnum.NORTH;
    } else if (orientationString.equals(DirectionEnum.EAST.toString())) {
      return DirectionEnum.EAST;
    } else if (orientationString.equals(DirectionEnum.SOUTH.toString())) {
      return DirectionEnum.SOUTH;
    } else if (orientationString.equals(DirectionEnum.WEST.toString())) {
      return DirectionEnum.WEST;
    } else {
      throw new IllegalArgumentException("Unknown direction: " + orientationString);
    }
  }
}
