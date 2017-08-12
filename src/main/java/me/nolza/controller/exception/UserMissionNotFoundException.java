package me.nolza.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by gain on 2017. 8. 12..
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "NotFound Error")
public class UserMissionNotFoundException extends RuntimeException {
    public UserMissionNotFoundException() { super(); }
    public UserMissionNotFoundException(String message) { super(message); }
    public UserMissionNotFoundException(String message, Throwable cause) { super(message, cause); }
    public UserMissionNotFoundException(Throwable cause) { super(cause); }
}
