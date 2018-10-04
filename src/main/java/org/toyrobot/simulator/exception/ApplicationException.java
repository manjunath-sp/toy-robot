package org.toyrobot.simulator.exception;

/**
 * Class to handle checked exceptions
 */
public class ApplicationException extends Exception {

  /**
   * Constructor
   *
   * @param message - the message
   */
  public ApplicationException(final String message) {
    super(message);
  }

  /**
   * Constructor with throwable
   *
   * @param message - the message
   * @param throwable - the throwable
   */
  public ApplicationException(final String message, final Throwable throwable) {
    super(message, throwable);
  }
}
