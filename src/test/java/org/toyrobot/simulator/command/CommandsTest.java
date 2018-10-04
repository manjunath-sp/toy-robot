package org.toyrobot.simulator.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.toyrobot.simulator.model.Coordinate;
import org.toyrobot.simulator.model.DirectionEnum;
import org.toyrobot.simulator.model.Position;

/**
 * Test Commands
 */
class CommandsTest {

  @Test
  void test_Command_Null() {
    Command leftCommand = new LeftCommand();

    Position currentPosition = leftCommand.executeCommand(null);

    assertNull(currentPosition);
  }

  @Test
  void test_Left_Command() {
    Command leftCommand = new LeftCommand();
    Position position = new Position(new Coordinate(2, 2), DirectionEnum.NORTH);

    Position currentPosition = leftCommand.executeCommand(position);

    assertEquals(new Position(2, 2, DirectionEnum.WEST),
        currentPosition);
  }

  @Test
  void test_Move_Command_North() {
    Command moveCommand = new MoveCommand();
    Position position = new Position(new Coordinate(2, 2), DirectionEnum.NORTH);

    Position currentPosition = moveCommand.executeCommand(position);

    assertEquals(new Position(2, 3, DirectionEnum.NORTH),
        currentPosition);
  }

  @Test
  void test_Move_Command_South() {
    Command moveCommand = new MoveCommand();
    Position position = new Position(new Coordinate(2, 2), DirectionEnum.SOUTH);

    Position currentPosition = moveCommand.executeCommand(position);
    assertEquals(new Position(2, 1, DirectionEnum.SOUTH),
        currentPosition);
  }

  @Test
  void test_Move_Command_East() {
    Command moveCommand = new MoveCommand();
    Position position = new Position(new Coordinate(2, 2), DirectionEnum.EAST);

    Position currentPosition = moveCommand.executeCommand(position);
    assertEquals(new Position(3, 2, DirectionEnum.EAST),
        currentPosition);
  }

  @Test
  void test_Move_Command_West() {
    Command moveCommand = new MoveCommand();
    Position position = new Position(new Coordinate(2, 2), DirectionEnum.WEST);

    Position currentPosition = moveCommand.executeCommand(position);
    assertEquals(new Position(1, 2, DirectionEnum.WEST),
        currentPosition);
  }

  @Test
  void test_Move_Command_No_Direction() {
    Command moveCommand = new MoveCommand();
    Position position = new Position(new Coordinate(2, 2), null);

    Position currentPosition = moveCommand.executeCommand(position);
    assertNull(currentPosition);
  }


  @Test
  void test_Place_Command() {
    Position placeCommandPosition = new Position(new Coordinate(0, 0),
        DirectionEnum.SOUTH);
    Command placeCommand = new PlaceCommand(placeCommandPosition);
    Position position = new Position(new Coordinate(2, 2), DirectionEnum.NORTH);

    Position currentPostion = placeCommand.executeCommand(position);
    assertEquals(placeCommandPosition, currentPostion);
  }

  @Test
  void test_report_Command() {
    Command reportCommand = new ReportCommand();
    Position position = new Position(new Coordinate(2, 2), DirectionEnum.NORTH);

    assertEquals(new Position(2, 2, DirectionEnum.NORTH),
        reportCommand.executeCommand(position));
  }

  @Test
  void test_Right_Command() {
    Command rightCommand = new RightCommand();
    Position position = new Position(new Coordinate(2, 2), DirectionEnum.NORTH);

    Position currentPosition = rightCommand.executeCommand(position);
    assertEquals(new Position(2, 2, DirectionEnum.EAST),
        currentPosition);
  }

  @Test
  void test_Right_Command_Null_Position() {
    Command rightCommand = new RightCommand();

    Position currentPosition = rightCommand.executeCommand(null);
    assertNull(currentPosition);
  }

  @Test
  void test_Right_Command_Right_Command_Right_Command_Right_command() {
    Command rightCommand = new RightCommand();
    Position position = new Position(new Coordinate(2, 2), DirectionEnum.NORTH);

    Position currentPosition = rightCommand.executeCommand(position);
    assertEquals(new Position(2, 2, DirectionEnum.EAST),
        currentPosition);

    currentPosition = rightCommand.executeCommand(currentPosition);
    assertEquals(new Position(2, 2, DirectionEnum.SOUTH),
        currentPosition);

    currentPosition = rightCommand.executeCommand(currentPosition);
    assertEquals(new Position(2, 2, DirectionEnum.WEST),
        currentPosition);

    currentPosition = rightCommand.executeCommand(currentPosition);
    assertEquals(new Position(2, 2, DirectionEnum.NORTH),
        currentPosition);
  }


  @Test
  void test_Left_Command_Left_Command_Left_Command_Left_Command() {
    Command leftCommand = new LeftCommand();

    Position position = new Position(new Coordinate(2, 2), DirectionEnum.NORTH);

    Position currentPosition = leftCommand.executeCommand(position);
    assertEquals(new Position(2, 2, DirectionEnum.WEST),
        currentPosition);

    currentPosition = leftCommand.executeCommand(currentPosition);
    assertEquals(new Position(2, 2, DirectionEnum.SOUTH),
        currentPosition);

    currentPosition = leftCommand.executeCommand(currentPosition);
    assertEquals(new Position(2, 2, DirectionEnum.EAST),
        currentPosition);

    currentPosition = leftCommand.executeCommand(currentPosition);
    assertEquals(new Position(2, 2, DirectionEnum.NORTH),
        currentPosition);
  }
}
