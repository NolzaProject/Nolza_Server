package me.nolza.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.nolza.controller.model.request.MissionRequest;
import me.nolza.controller.model.response.MissionResponse;
import me.nolza.domain.CategoryMission;
import me.nolza.domain.Mission;
import me.nolza.repository.CategoryMissionRepository;
import me.nolza.repository.MissionRepository;
import me.nolza.service.custom.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
@Service
@Slf4j
public class MissionServiceImpl implements MissionService {

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private CategoryMissionRepository categoryMissionRepository;

    @Override
    public void createMission(MissionRequest missionRequest){
        Mission mission = new Mission();
        mission.setTitle(missionRequest.getTitle());
        mission.setDescription(missionRequest.getDescription());
        mission.setKeyword(missionRequest.getKeyword());
        mission.setDifficulty(missionRequest.getLevel());
        this.missionRepository.save(mission);
    }

    @Override
    public void deleteMission(Long Id){
        this.missionRepository.delete(Id);
    }

    @Override
    public Mission updateMission(MissionRequest missionRequest){
        Mission missionTmp = this.missionRepository.findOne(missionRequest.getId());
        Mission mission = new Mission();
        mission.setId(missionTmp.getId());
        mission.setTitle(missionRequest.getTitle());
        mission.setDescription(missionRequest.getDescription());
        mission.setKeyword(missionRequest.getKeyword());
        mission.setDifficulty(missionRequest.getLevel());
        mission.setCreatedDate(missionTmp.getCreatedDate());
        mission.setLastModifiedDate(missionTmp.getLastModifiedDate());
        this.missionRepository.save(mission);

        return mission;
    }

    @Override
    public List<MissionResponse> getMissionList(){
        List<Mission> missionList = this.missionRepository.findAll();
        List<MissionResponse> missionResponseList = new ArrayList<>();

        for(Mission mission : missionList){
            MissionResponse missionResponse = new MissionResponse();
            missionResponse.setId(mission.getId());
            missionResponse.setTitle(mission.getTitle());
            missionResponse.setKeyword(mission.getKeyword());
            missionResponse.setDescription(mission.getDescription());
            missionResponse.setDifficulty(mission.getDifficulty());

            missionResponseList.add(missionResponse);
        }
        return missionResponseList;
    }

    @Override
    public List<MissionResponse> readCategoryMissions(Long categoryId){
        List<CategoryMission> categoryMissions =  this.categoryMissionRepository.findByCategoryId(categoryId);
        List<MissionResponse> missionResponseList = new ArrayList<>();

        System.out.println(categoryId);
        System.out.println(categoryMissions);

        for(CategoryMission categoryMission : categoryMissions){
            Mission mission = this.missionRepository.findOne(categoryMission.getMissionId());
            MissionResponse missionResponse = new MissionResponse();
            missionResponse.setId(mission.getId());
            missionResponse.setTitle(mission.getTitle());
            missionResponse.setDescription(mission.getDescription());
            missionResponse.setKeyword(mission.getKeyword());
            missionResponse.setDifficulty(mission.getDifficulty());

            missionResponseList.add(missionResponse);
        }

        return missionResponseList;
    }
}
