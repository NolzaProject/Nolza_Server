package me.nolza.service.custom;

import me.nolza.controller.model.request.MissionRequest;
import me.nolza.controller.model.response.MissionResponse;
import me.nolza.domain.Mission;

import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
public interface MissionService {
     void createMission(MissionRequest missionRequest);
     void deleteMission(Long Id);
     Mission updateMission(MissionRequest missionRequest);
     List<MissionResponse> getMissions();
     List<MissionResponse> readCategoryMissions(Long categoryId);
     List<MissionResponse> searchMissions(String keyword);
}
