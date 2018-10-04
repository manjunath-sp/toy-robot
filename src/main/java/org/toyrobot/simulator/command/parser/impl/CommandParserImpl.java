package org.toyrobot.simulator.command.parser.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.toyrobot.simulator.command.Command;
import org.toyrobot.simulator.command.parser.CommandParser;
import org.toyrobot.simulator.exception.ApplicationException;

/**
 * Implementation for {@link CommandParser}
 */
public class CommandParserImpl implements CommandParser {

  @Override
  public List<Command> parseCommands(final List<String> commandStrings)
      throws ApplicationException {
    return commandStrings.stream()
        .map(CommandParserHelper::parseCommand)
        .collect(Collectors.toList());

  }

}
