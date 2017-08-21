package me.nolza.service.custom;

import me.nolza.controller.model.request.MissionKeywordRequest;

/**
 * Created by gain on 2017. 8. 21..
 */
public interface MissionKeywordService {
    void createMissionKeyword(MissionKeywordRequest missionKeywordRequest);
    void deleteMissionKeyword(MissionKeywordRequest missionKeywordRequest);
}
