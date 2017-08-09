package me.nolza.service.custom;

import me.nolza.controller.model.request.CategoryMissionRequest;
/**
 * Created by gain on 2017. 8. 9..
 */
public interface CategoryMissionService {
    void createCategoryMission(CategoryMissionRequest categoryMissionRequest);
    void deleteCategoryMission(CategoryMissionRequest categoryMissionRequest);
}
