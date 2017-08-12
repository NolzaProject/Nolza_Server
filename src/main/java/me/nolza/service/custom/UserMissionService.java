package me.nolza.service.custom;

import me.nolza.controller.model.request.UserMissionRequset;
import me.nolza.controller.model.response.UserMissionResponse;

import java.util.List;

/**
 * Created by gain on 2017. 8. 12..
 */
public interface UserMissionService {
    void createUserMission(UserMissionRequset userMissionRequset);
    List<UserMissionResponse> getUserMissionList(Long userId);
}
