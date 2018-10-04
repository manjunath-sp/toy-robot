package org.toyrobot.simulator.command.parser.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.toyrobot.simulator.command.Command;
import org.toyrobot.simulator.command.LeftCommand;
import org.toyrobot.simulator.command.MoveCommand;
import org.toyrobot.simulator.command.NullCommand;
import org.toyrobot.simulator.command.PlaceCommand;
import org.toyrobot.simulator.command.ReportCommand;
import org.toyrobot.simulator.command.RightCommand;
import org.toyrobot.simulator.model.DirectionEnum;
import org.toyrobot.simulator.model.Position;

/**
 * The type Command parser helper test.
 */
class CommandParserHelperTest {

  private Position position;

  @BeforeEach
  void setUp() {
    this.position = new Position(0, 0, DirectionEnum.NORTH);
  }

  @Test
  void test_Left() {
    Command command = CommandParserHelper.parseCommand("LEFT");
    assertTrue(command instanceof LeftCommand);
  }

  @Test
  void test_Null() {
    Command command = CommandParserHelper.parseCommand(null);
    assertTrue(command instanceof NullCommand);
  }

  @Test
  void test_Invalid() {
    Command command = CommandParserHelper.parseCommand("RANDOM");
    assertTrue(command instanceof NullCommand);
  }

  @Test
  void test_Move() {
    Command command = CommandParserHelper.parseCommand("MOVE");
    assertTrue(command instanceof MoveCommand);
  }

  @Test
  void test_Place() {
    Command command = CommandParserHelper.parseCommand("PLACE 0,0,NORTH");
    assertTrue(command instanceof PlaceCommand);
  }

  @Test
  void test_Report() {
    Command command = CommandParserHelper.parseCommand("REPORT");
    assertTrue(command instanceof ReportCommand);
  }

  @Test
  void test_Right() {
    Command command = CommandParserHelper.parseCommand("RIGHT");
    assertTrue(command instanceof RightCommand);
  }

  @Test
  void test_Valid_PlaceA() {
    Command command = CommandParserHelper.parseCommand("PLACE 0,0,NORTH");
    Position currentPosition = command.executeCommand(this.position);
    assertEquals(new Position(0, 0, DirectionEnum.NORTH), currentPosition);
  }

  @Test
  void test_Valid_PlaceB() {
    Command command = CommandParserHelper.parseCommand("PLACE 2,3,SOUTH");
    Position currentPosition = command.executeCommand(this.position);
    assertEquals(new Position(2, 3, DirectionEnum.SOUTH), currentPosition);
  }

  @Test
  void test_Valid_PlaceC() {
    Command command = CommandParserHelper.parseCommand("PLACE 4,2,EAST");
    Position currentPosition = command.executeCommand(this.position);
    assertNotEquals(new Position(2, 4, DirectionEnum.WEST), currentPosition);
  }

  @Test
  void test_Invalid_PlaceA() {
    Command command = CommandParserHelper.parseCommand("PLACE4,2,EAST");
    Position currentPosition = command.executeCommand(this.position);
    assertTrue(command instanceof NullCommand);
    assertEquals(this.position, currentPosition);
  }

  @Test
  void test_Invalid_PlaceB() {
    Command command = CommandParserHelper.parseCommand("PLACE 4, 2,EAST");
    Position currentPosition = command.executeCommand(this.position);
    assertTrue(command instanceof NullCommand);
    assertEquals(this.position, currentPosition);
  }

  @Test
  void test_Invalid_PlaceC() {
    Command command = CommandParserHelper.parseCommand("PLACE 4,2,HUBWARD");
    Position currentPosition = command.executeCommand(this.position);
    assertTrue(command instanceof NullCommand);
    assertEquals(this.position, currentPosition);
  }

}
