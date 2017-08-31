package me.nolza.controller;

import me.nolza.controller.model.request.MissionRequest;
import me.nolza.controller.model.response.MissionResponse;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.service.custom.MissionService;
import me.nolza.service.custom.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
@RestController
@RequestMapping(value = "/api/v1/missions")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @Autowired
    private S3Service s3Service;

    @RequestMapping(method = RequestMethod.POST)
    public NolzaApiResponse createMission(@Valid @RequestBody MissionRequest missionRequest, MultipartFile multipartFile){
        this.missionService.createMission(missionRequest);
        s3Service.createObject(multipartFile);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public NolzaApiResponse deleteMission(@PathVariable Long Id){
        this.missionService.deleteMission(Id);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public NolzaApiResponse updateMission(@Valid @RequestBody MissionRequest missionRequest){
        this.missionService.updateMission(missionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public NolzaApiResponse<List<MissionResponse>> getMissions(){
        List<MissionResponse> missionResponses = this.missionService.getMissions();
        return new NolzaApiResponse<>(missionResponses);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{categoryId}")
    public NolzaApiResponse<List<MissionResponse>> readCategoryMission(@PathVariable Long categoryId){
        List<MissionResponse> missionResponses = this.missionService.readCategoryMissions(categoryId);
        return new NolzaApiResponse<>(missionResponses);
    }
}
