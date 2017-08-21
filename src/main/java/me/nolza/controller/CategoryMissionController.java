package me.nolza.controller;

import me.nolza.controller.model.request.CategoryMissionRequest;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.service.custom.CategoryMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by gain on 2017. 8. 7..
 */
@RestController
@RequestMapping(value = "/api/v1/categoryMissions")
public class CategoryMissionController {

    @Autowired
    private CategoryMissionService categoryMissionService;

    @PostMapping()
    public NolzaApiResponse createCategoryMission(@RequestBody CategoryMissionRequest categoryMissionRequest){
        this.categoryMissionService.createCategoryMission(categoryMissionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public NolzaApiResponse deleteCategoryMission(@RequestBody CategoryMissionRequest categoryMissionRequest){
        this.categoryMissionService.deleteCategoryMission(categoryMissionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }
}
