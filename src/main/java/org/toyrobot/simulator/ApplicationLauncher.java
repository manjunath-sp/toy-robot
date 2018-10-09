package org.toyrobot.simulator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.toyrobot.simulator.command.Command;
import org.toyrobot.simulator.command.parser.CommandParser;
import org.toyrobot.simulator.command.parser.impl.CommandParserImpl;
import org.toyrobot.simulator.exception.ApplicationException;
import org.toyrobot.simulator.model.Coordinate;
import org.toyrobot.simulator.model.Position;
import org.toyrobot.simulator.robot.Robot;
import org.toyrobot.simulator.robot.impl.RobotImpl;
import org.toyrobot.simulator.utils.FileUtils;

/**
 * Application Launcher class for the Toy robot simulator.
 */
public class ApplicationLauncher {

  private static final Logger LOGGER = Logger
      .getLogger(ApplicationLauncher.class.getName());

  private static final String SRC_MAIN_RESOURCES_INPUT_DATA_TXT = "src/main/resources/input-1.txt";


  public static void main(String[] args) {

    List<String> stringList = new ArrayList<>();
    if (args == null || args.length == 0) {
      stringList.addAll(processFile(SRC_MAIN_RESOURCES_INPUT_DATA_TXT));
    } else {
      stringList.addAll(processFile(args[0]));
    }
    if (!stringList.isEmpty()) {
      List<String> positions = ApplicationLauncher.processCommands(stringList);
      try {
        FileUtils.createFile(positions);
      } catch (IOException e) {
        LOGGER.log(Level.SEVERE, "Unable to write to output file");
      }
    }
  }

  static List<String> processCommands(List<String> stringList) {
    if (stringList.isEmpty()) {
      LOGGER.log(Level.WARNING, "No records to process in the file");
    } else {
      CommandParser commandParser = new CommandParserImpl();
      try {
        List<Command> commands = commandParser.parseCommands(stringList);
        Robot robot = new RobotImpl(new Coordinate(4, 4));
        return robot.executeCommandsAndReportPositions(commands).stream()
            .map(Position::toString).collect(Collectors.toList());
      } catch (ApplicationException e) {
        LOGGER.log(Level.SEVERE, "Unable to parse the commands", e);
      }
    }
    return Collections.emptyList();
  }

  private static List<String> processFile(String file) {
    try {
      return FileUtils.readFileAsList(file);
    } catch (FileNotFoundException e) {
      LOGGER.log(Level.SEVERE, "Unable to read the file:" + file);
    }
    return Collections.emptyList();
  }
}
