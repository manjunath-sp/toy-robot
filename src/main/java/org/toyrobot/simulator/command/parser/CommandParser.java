package org.toyrobot.simulator.command.parser;

import java.util.List;
import org.toyrobot.simulator.command.Command;
import org.toyrobot.simulator.exception.ApplicationException;

/**
 * Interface to parse a commands file.
 */
public interface CommandParser {

  /**
   * Returns a list of valid commands from an input file.
   *
   * @param commands - the absolute path to the file
   * @return - a List of {@link Command}
   */
  List<Command> parseCommands(List<String> commands) throws ApplicationException;


}
