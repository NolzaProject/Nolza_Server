package me.nolza.controller;

import me.nolza.controller.model.request.UserMissionRequset;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.controller.model.response.UserMissionResponse;
import me.nolza.service.custom.UserMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by gain on 2017. 8. 12..
 */
@RestController
@RequestMapping(value = "/api/v1/userMissions")
public class UserMissoinCotroller {

    @Autowired
    private UserMissionService userMissionService;

    @PostMapping()
    public NolzaApiResponse createUserMission(@Valid @RequestBody UserMissionRequset userMissionRequset){
        this.userMissionService.createUserMission(userMissionRequset);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public NolzaApiResponse<List<UserMissionResponse>> getUserMissions(@PathVariable Long userId){
        List<UserMissionResponse> userMissionResponses = this.userMissionService.getUserMissions(userId);
        return new NolzaApiResponse<>(userMissionResponses);
    }
}
