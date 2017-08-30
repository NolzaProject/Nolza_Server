package me.nolza.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.nolza.controller.model.request.CategoryMissionRequest;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.service.custom.CategoryMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by gain on 2017. 8. 7..
 */
@Api(description = "카테고리에 해당되는 미션 관리 API")
@RestController
@RequestMapping(value = "/api/v1/categoryMissions")
public class CategoryMissionController {

    @Autowired
    private CategoryMissionService categoryMissionService;

    @ApiOperation(value = "", notes = "카테고리에 미션을 할당합니다.")
    @PostMapping()
    public NolzaApiResponse createCategoryMission(@RequestBody CategoryMissionRequest categoryMissionRequest){
        this.categoryMissionService.createCategoryMission(categoryMissionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @ApiOperation(value = "", notes = "카테고리에 할당된 미션을 삭제합니다.")
    @RequestMapping(method = RequestMethod.DELETE)
    public NolzaApiResponse deleteCategoryMission(@RequestBody CategoryMissionRequest categoryMissionRequest){
        this.categoryMissionService.deleteCategoryMission(categoryMissionRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }
}
