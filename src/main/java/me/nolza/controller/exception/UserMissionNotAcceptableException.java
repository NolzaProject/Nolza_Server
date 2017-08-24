package me.nolza.controller.exception;

/**
 * Created by gain on 2017. 8. 24..
 */
public class UserMissionNotAcceptableException extends RuntimeException {
    public UserMissionNotAcceptableException() { super(); }
    public UserMissionNotAcceptableException(String message) { super(message); }
    public UserMissionNotAcceptableException(String message, Throwable cause) { super(message, cause); }
    public UserMissionNotAcceptableException(Throwable cause) { super(cause); }
}
