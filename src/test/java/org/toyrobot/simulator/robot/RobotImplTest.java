package org.toyrobot.simulator.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.toyrobot.simulator.command.Command;
import org.toyrobot.simulator.command.parser.CommandParser;
import org.toyrobot.simulator.command.parser.impl.CommandParserImpl;
import org.toyrobot.simulator.model.Coordinate;
import org.toyrobot.simulator.model.DirectionEnum;
import org.toyrobot.simulator.model.Position;
import org.toyrobot.simulator.robot.impl.RobotImpl;
import org.toyrobot.simulator.utils.FileUtils;

/**
 * Unit test for Robot Impl
 */
class RobotImplTest {

  private final Robot robot = new RobotImpl(new Coordinate(4, 4));

  private final CommandParser commandParser = new CommandParserImpl();


  @Test
  void test_Valid_Input_1() throws Exception {

    List<Command> commands = this.commandParser
        .parseCommands(FileUtils.readFileAsList("src/main/resources/input-1.txt"));

    List<Position> positions = this.robot
        .executeCommandsAndReportPositions(commands);

    assertEquals(1, positions.size());
    assertEquals(0, positions.get(0).getCoordinate().getX());
    assertEquals(1, positions.get(0).getCoordinate().getY());
    assertEquals(DirectionEnum.NORTH, positions.get(0).getDirection());

  }

  @Test
  void test_Valid_Input_2() throws Exception {

    List<Command> commands = this.commandParser
        .parseCommands(FileUtils.readFileAsList("src/main/resources/input-2.txt"));

    List<Position> positions = this.robot
        .executeCommandsAndReportPositions(commands);

    assertEquals(1, positions.size());
    assertEquals(0, positions.get(0).getCoordinate().getX());
    assertEquals(0, positions.get(0).getCoordinate().getY());
    assertEquals(DirectionEnum.WEST, positions.get(0).getDirection());

  }

  @Test
  void test_Valid_Input_3() throws Exception {

    List<Command> commands = this.commandParser
        .parseCommands(FileUtils.readFileAsList("src/main/resources/input-3.txt"));

    List<Position> positions = this.robot
        .executeCommandsAndReportPositions(commands);

    assertEquals(1, positions.size());
    assertEquals(3, positions.get(0).getCoordinate().getX());
    assertEquals(3, positions.get(0).getCoordinate().getY());
    assertEquals(DirectionEnum.NORTH, positions.get(0).getDirection());

  }

  @Test
  void test_Valid_Input_4() throws Exception {

    List<Command> commands = this.commandParser
        .parseCommands(FileUtils.readFileAsList("src/main/resources/input-4.txt"));

    List<Position> positions = this.robot
        .executeCommandsAndReportPositions(commands);

    assertEquals(2, positions.size());
    assertEquals(3, positions.get(0).getCoordinate().getX());
    assertEquals(3, positions.get(0).getCoordinate().getY());
    assertEquals(DirectionEnum.NORTH, positions.get(0).getDirection());

    assertEquals(3, positions.get(1).getCoordinate().getX());
    assertEquals(3, positions.get(1).getCoordinate().getY());
    assertEquals(DirectionEnum.EAST, positions.get(1).getDirection());

  }


  @Test
  void test_Valid_Invalid_Input() throws Exception {

    List<Command> commands = this.commandParser
        .parseCommands(FileUtils.readFileAsList("src/main/resources/input-valid-invalid.txt"));

    List<Position> positions = this.robot
        .executeCommandsAndReportPositions(commands);

    assertEquals(1, positions.size());
    assertEquals(0, positions.get(0).getCoordinate().getX());
    assertEquals(1, positions.get(0).getCoordinate().getY());
    assertEquals(DirectionEnum.NORTH, positions.get(0).getDirection());

  }
}
