package me.nolza.controller.exception;

/**
 * Created by gain on 2017. 9. 5..
 */
public class NotUniqueIdException extends RuntimeException {
    public NotUniqueIdException() { super(); }
    public NotUniqueIdException(String message) { super(message); }
    public NotUniqueIdException(String message, Throwable cause) { super(message, cause); }
    public NotUniqueIdException(Throwable cause) { super(cause); }
}
