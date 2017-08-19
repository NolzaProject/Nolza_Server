package me.nolza.controller.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by gain on 2017. 8. 14..
 */
@Getter
@Setter
public class UserRequest {
    private Long Id;
    @NotNull
    private String email;
    private String nation;
    private String userName;
    @NotNull
    private String password;
    private String duration;
}
