package me.nolza.controller;

import me.nolza.controller.model.request.UserMissionRequest;
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
@RequestMapping(value = "/api/v1/usermissions")
public class UserMissoinCotroller {

    @Autowired
    private UserMissionService userMissionService;

    @RequestMapping(method = RequestMethod.POST)
    public NolzaApiResponse createUserMission(@Valid @RequestBody UserMissionRequest userMissionRequest){
        this.userMissionService.createUserMission(userMissionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public NolzaApiResponse<List<UserMissionResponse>> readUserMissions(@PathVariable Long userId){
        List<UserMissionResponse> userMissionResponses = this.userMissionService.readUserMissions(userId);
        return new NolzaApiResponse<>(userMissionResponses);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public NolzaApiResponse updateUserMission(@RequestBody UserMissionRequest userMissionRequest){
        this.userMissionService.updateUserMission(userMissionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @RequestMapping(value = "/checked", method = RequestMethod.PUT)
    public NolzaApiResponse checkedUserMissions(@RequestBody List<UserMissionRequest> userMissionRequests){
        this.userMissionService.checkedUserMissions(userMissionRequests);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

}
