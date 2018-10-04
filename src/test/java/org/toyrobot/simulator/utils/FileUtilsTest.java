package org.toyrobot.simulator.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link FileUtils}
 */
class FileUtilsTest {

  @Test
  void readFileAsList() throws FileNotFoundException {
    File resourcesDirectory = new File("src/main/resources/input-1.txt");
    List<String> fileContent = FileUtils
        .readFileAsList(resourcesDirectory.getAbsolutePath());
    assertEquals(3, fileContent.size());
  }

  @Test
  void readFileAsListEmptyFileFromFileSystem() {

    File resourcesDirectory = new File("src/test/resources/non_existing_file.txt");
    assertThrows(FileNotFoundException.class,
        () -> FileUtils.readFileAsList(resourcesDirectory.getAbsolutePath()));
  }
}