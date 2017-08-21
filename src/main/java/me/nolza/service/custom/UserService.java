package me.nolza.service.custom;

import me.nolza.controller.model.request.UserRequest;

import javax.servlet.http.HttpSession;


/**
 * Created by gain on 2017. 8. 14..
 */
public interface UserService {
    void createUser(UserRequest userRequest);
    String loginUser(UserRequest userRequest, HttpSession session);
}
