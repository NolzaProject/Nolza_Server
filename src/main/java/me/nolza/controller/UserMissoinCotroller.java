package me.nolza.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "사용자가 수행한 미션 API")
@RestController
@RequestMapping(value = "/api/v1/usermissions")
public class UserMissoinCotroller {

    @Autowired
    private UserMissionService userMissionService;

    @ApiOperation(value = "", notes = "사용자가 수행한 미션을 생성합니다.")
    @RequestMapping(method = RequestMethod.POST)
    public NolzaApiResponse createUserMission(UserMissionRequest userMissionRequest){
        this.userMissionService.createUserMission(userMissionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @ApiOperation(value = "파라미터 사용자 email", notes = "해당 사용자가 수행한 전체 미션 목록을 가져옵니다.")
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public NolzaApiResponse<List<UserMissionResponse>> readUserMissions(@PathVariable String email){
        List<UserMissionResponse> userMissionResponses = this.userMissionService.readUserMissions(email);
        return new NolzaApiResponse<>(userMissionResponses);
    }

    @ApiOperation(value = "", notes = "사용자가 수행한 미션을 수정합니다.")
    @RequestMapping(method = RequestMethod.PUT)
    public NolzaApiResponse updateUserMission(UserMissionRequest userMissionRequest){
        this.userMissionService.updateUserMission(userMissionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @ApiOperation(value = "", notes = "사용자가 수행한 미션을 수행 완료 상태로 수정합니다.")
    @RequestMapping(value = "/checked", method = RequestMethod.PUT)
    public NolzaApiResponse checkedUserMissions(@RequestBody List<UserMissionRequest> userMissionRequests){
        this.userMissionService.checkedUserMissions(userMissionRequests);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

}
