package me.nolza.service.custom;

import me.nolza.controller.model.request.MissionRequest;
import me.nolza.controller.model.response.MissionResponse;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.controller.model.response.RecommendMissionsResponse;
import me.nolza.domain.Mission;

import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
public interface MissionService {
     void createMission(MissionRequest missionRequest, String imageUrl);
     void deleteMission(Long Id);
     Mission updateMission(MissionRequest missionRequest);
     List<MissionResponse> getMissions();
     RecommendMissionsResponse recommendMissions(String email);
     NolzaApiResponse<List<MissionResponse>> searchMissions(String description);
}
