package org.toyrobot.simulator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility method to read file
 */
public class FileUtils {

  private static final Logger LOGGER = Logger.getLogger(FileUtils.class.getName());

  /**
   * Prevent initialization of utility class
   */
  private FileUtils() {
  }

  /**
   * Read file as stream and return the file contents as List
   */
  public static List<String> readFileAsList(String filePath) throws FileNotFoundException {

    List<String> fileContents = new ArrayList<>();

    try (Scanner scanner = new Scanner(new FileInputStream(filePath), "UTF-8")) {
      while (scanner.hasNext()) {
        String line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
          fileContents.add(line);
        }
      }
    }
    return fileContents;
  }


  /**
   * Creates a file result.txt in the current working directory
   *
   * @param contents - content to be written to the file
   */
  public static void createFile(List<String> contents) throws IOException {

    File directory = new File(".");
    String outputFilePath = directory.getCanonicalPath() + File.separator + "result.txt";

    if (LOGGER.isLoggable(Level.INFO)) {
      LOGGER.info(String.format("Output file path:%s", outputFilePath));
    }

    File file = new File(outputFilePath);
    try (FileWriter fw = new FileWriter(file)) {
      for (String string : contents) {
        if (LOGGER.isLoggable(Level.INFO)) {
          LOGGER.info(string);
        }
        fw.write(string);
        fw.write(System.getProperty("line.separator"));
      }
      fw.flush();
    }
  }
}
