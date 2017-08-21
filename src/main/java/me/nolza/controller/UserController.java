package me.nolza.controller;

import me.nolza.controller.model.request.UserRequest;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by gain on 2017. 8. 14..
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public NolzaApiResponse createUser(@Valid @RequestBody UserRequest userRequest){
        this.userService.createUser(userRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public NolzaApiResponse<String> loginUser(@Valid @RequestBody UserRequest userRequest, HttpSession session){
        String token = this.userService.loginUser(userRequest, session);
        return new NolzaApiResponse<>(token);
    }

}
