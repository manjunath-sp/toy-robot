package org.toyrobot.simulator.command.parser.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.toyrobot.simulator.command.Command;
import org.toyrobot.simulator.command.MoveCommand;
import org.toyrobot.simulator.command.NullCommand;
import org.toyrobot.simulator.command.PlaceCommand;
import org.toyrobot.simulator.command.ReportCommand;
import org.toyrobot.simulator.command.parser.CommandParser;
import org.toyrobot.simulator.exception.ApplicationException;
import org.toyrobot.simulator.utils.FileUtils;

/**
 * Unit tests for {@link org.toyrobot.simulator.command.parser.CommandParser}
 */
class CommandParserImplTest {

  private final CommandParser commandParser = new CommandParserImpl();

  @Test
  void test_Invalid_Commands() throws ApplicationException, FileNotFoundException {
    String filePath = "src/main/resources/input-invalid.txt";

    List<Command> commands = this.commandParser
        .parseCommands(FileUtils.readFileAsList(filePath));

    assertEquals(2, commands.size());

    for (Command command : commands) {
      assertTrue(command instanceof NullCommand);
    }
  }

  @Test
  void test_Valid_Commands() throws ApplicationException, FileNotFoundException {
    String filePath = "src/main/resources/input-1.txt";

    List<Command> commands = this.commandParser
        .parseCommands(FileUtils.readFileAsList(filePath));

    assertEquals(3, commands.size());
    assertTrue(commands.get(0) instanceof PlaceCommand);
    assertTrue(commands.get(1) instanceof MoveCommand);
    assertTrue(commands.get(2) instanceof ReportCommand);
  }


  @Test
  void test_Valid_And_Invalid_Commands() throws ApplicationException, FileNotFoundException {
    String filePath = "src/main/resources/input-valid-invalid.txt";

    List<Command> commands = this.commandParser
        .parseCommands(FileUtils.readFileAsList(filePath));

    assertEquals(4, commands.size());
    assertTrue(commands.get(0) instanceof PlaceCommand);
    assertTrue(commands.get(1) instanceof MoveCommand);
    assertTrue(commands.get(2) instanceof NullCommand);
    assertTrue(commands.get(3) instanceof ReportCommand);
  }
}