package me.nolza.service.custom;

import me.nolza.controller.model.request.UserMissionRequest;
import me.nolza.controller.model.response.UserMissionResponse;

import java.util.List;

/**
 * Created by gain on 2017. 8. 12..
 */
public interface UserMissionService {
    void createUserMission(UserMissionRequest userMissionRequest);
    List<UserMissionResponse> readUserMissions(Long userId);
    void updateUserMission(UserMissionRequest userMissionRequest);
    void checkedUserMissions(List<UserMissionRequest> userMissionRequests);
}
