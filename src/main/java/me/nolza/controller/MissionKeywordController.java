package me.nolza.controller;

import me.nolza.controller.model.request.MissionKeywordRequest;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.service.custom.MissionKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gain on 2017. 8. 21..
 */
@RestController
@RequestMapping(value = "/api/v1/mk")
public class MissionKeywordController {

    @Autowired
    private MissionKeywordService missionKeywordService;

    @PostMapping()
    public NolzaApiResponse createMissionKeyword(@RequestBody MissionKeywordRequest missionKeywordRequest){
        this.missionKeywordService.createMissionKeyword(missionKeywordRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @PostMapping("/delete")
    public NolzaApiResponse deleteCategoryMission(@RequestBody MissionKeywordRequest missionKeywordRequest){
        this.missionKeywordService.deleteMissionKeyword(missionKeywordRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }
}
