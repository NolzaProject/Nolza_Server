package me.nolza.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.nolza.controller.model.request.CategoryMissionRequest;
import me.nolza.domain.CategoryMission;
import me.nolza.domain.CategoryMissionId;
import me.nolza.repository.CategoryMissionRepository;
import me.nolza.service.custom.CategoryMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by gain on 2017. 8. 9..
 */
@Service
@Slf4j
public class CategoryMissionServiceImpl implements CategoryMissionService {


    @Autowired
    private CategoryMissionRepository categoryMissionRepository;

    @Override
    public void createCategoryMission(CategoryMissionRequest categoryMissionRequest) {
        List<Long> missionIds = categoryMissionRequest.getMissionIds();

        for(Long missionId : missionIds){
            CategoryMission categoryMission = new CategoryMission();
            categoryMission.setCategoryId(categoryMissionRequest.getCategoryId());
            categoryMission.setMissionId(missionId);

            this.categoryMissionRepository.save(categoryMission);
        }
    }

    @Override
    public void deleteCategoryMission(CategoryMissionRequest categoryMissionRequest) {
        List<Long> missionIds = categoryMissionRequest.getMissionIds();

        for(Long missionId : missionIds){
            CategoryMissionId categoryMissionId = new CategoryMissionId();
            categoryMissionId.setCategoryId(categoryMissionRequest.getCategoryId());
            categoryMissionId.setMissionId(missionId);
            this.categoryMissionRepository.delete(categoryMissionId);
        }

    }
}
