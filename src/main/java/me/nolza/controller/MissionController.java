package me.nolza.controller;

import me.nolza.controller.model.request.MissionRequest;
import me.nolza.controller.model.response.MissionResponse;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.service.custom.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
@RestController
@RequestMapping(value = "/api/v1/mission")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @PostMapping()
    public NolzaApiResponse createMission(@Valid @RequestBody MissionRequest missionRequest){
        this.missionService.createMission(missionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @GetMapping("/delete/{Id}")
    public NolzaApiResponse deleteMission(@PathVariable Long Id){
        this.missionService.deleteMission(Id);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @PostMapping("/update")
    public NolzaApiResponse updateMission(@Valid @RequestBody MissionRequest missionRequest){
        this.missionService.updateMission(missionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @GetMapping("/list")
    public NolzaApiResponse<List<MissionResponse>> getMissionList(){
        List<MissionResponse> missionResponseList = this.missionService.getMissionList();
        return new NolzaApiResponse<>(missionResponseList);
    }

    @GetMapping("/categoryId/{categoryId}")
    public NolzaApiResponse<List<MissionResponse>> readCategoryMission(@PathVariable Long categoryId){
        List<MissionResponse> missionResponseList = this.missionService.readCategoryMissions(categoryId);
        return new NolzaApiResponse<>(missionResponseList);
    }

    @GetMapping("/keywordId/{keywordId}")
    public NolzaApiResponse<List<MissionResponse>> searchMissions(@PathVariable Long keywordId){
        List<MissionResponse> missionResponseList = this.missionService.searchMissions(keywordId);
        return new NolzaApiResponse<>(missionResponseList);
    }
}
