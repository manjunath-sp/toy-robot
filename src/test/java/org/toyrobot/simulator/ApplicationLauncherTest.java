package org.toyrobot.simulator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toyrobot.simulator.utils.FileUtils;

class ApplicationLauncherTest {

  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  
  @BeforeAll
  static void setUp() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(outContent));
  }

  @Test
  void processCommands_File_Exists() throws FileNotFoundException {

    File resourcesDirectory = new File("src/main/resources/input-1.txt");
    List<String> fileContent = FileUtils
        .readFileAsList(resourcesDirectory.getAbsolutePath());

    List<String> result = ApplicationLauncher.processCommands(fileContent);
    assertEquals("0,1,NORTH", result.get(0));
  }

  @Test
  void processCommands_File_Does_Not_Exist() throws FileNotFoundException {

    File resourcesDirectory = new File("src/main/resources/input-no-file.txt");
    Assertions.assertThrows(FileNotFoundException.class, () -> FileUtils
        .readFileAsList(resourcesDirectory.getAbsolutePath()));

  }


  @Test
  void processCommands_File_Exists_Two_Results() throws FileNotFoundException {

    File resourcesDirectory = new File("src/main/resources/input-4.txt");
    List<String> fileContent = FileUtils
        .readFileAsList(resourcesDirectory.getAbsolutePath());

    List<String> result = ApplicationLauncher.processCommands(fileContent);
    assertEquals("3,3,NORTH", result.get(0));
    assertEquals("3,3,EAST", result.get(1));
  }

  @Test
  void testMain_No_Args() {
    ApplicationLauncher.main(new String[0]);
    assertTrue(
        outContent.toString()
            .contains("0,1,NORTH"));
  }


  @Test
  void testMain_With_Args() {

    String[] args = {"src/main/resources/input-4.txt"};

    ApplicationLauncher.main(args);
    assertTrue(outContent.toString().contains("3,3,NORTH"));
    assertTrue(outContent.toString().contains("3,3,EAST"));
  }


  @Test
  void testMain_With_Args_File_Not_Exists() {

    String[] args = {"src/main/resources/input-random-file.txt"};

    ApplicationLauncher.main(args);
    assertTrue(outContent.toString().contains("Unable to read the file:"));
  }
}