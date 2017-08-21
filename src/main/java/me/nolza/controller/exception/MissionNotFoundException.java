package me.nolza.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by gain on 2017. 8. 21..
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "NotFound Error")
public class MissionNotFoundException extends RuntimeException {
    public MissionNotFoundException() { super(); }
    public MissionNotFoundException(String message) { super(message); }
    public MissionNotFoundException(String message, Throwable cause) { super(message, cause); }
    public MissionNotFoundException(Throwable cause) { super(cause); }
}
