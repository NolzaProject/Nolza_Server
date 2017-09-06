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
    public void createMission(MissionRequest missionRequest, String imageUrl){
        Mission mission = new Mission();
        mission.setTitle(missionRequest.getTitle());
        mission.setLocation(missionRequest.getLocation());
        mission.setDifficulty(missionRequest.getDifficulty());
        mission.setBusinessHour(missionRequest.getBusinessHour());
        mission.setPhoneNumber(missionRequest.getPhoneNumber());
        mission.setCharge(missionRequest.getCharge());
        mission.setDescription(missionRequest.getDescription());
        mission.setImageUrl(imageUrl);
        this.missionRepository.save(mission);
    }

    @Override
    public void deleteMission(Long Id){
        this.missionRepository.delete(Id);
    }

    //TODO image update
    @Override
    public Mission updateMission(MissionRequest missionRequest){
        Mission missionTmp = this.missionRepository.findOne(missionRequest.getId());
        Mission mission = new Mission();
        mission.setId(missionTmp.getId());
        mission.setTitle(missionRequest.getTitle());
        mission.setLocation(missionRequest.getLocation());
        mission.setDifficulty(missionRequest.getDifficulty());
        mission.setBusinessHour(missionRequest.getBusinessHour());
        mission.setPhoneNumber(missionRequest.getPhoneNumber());
        mission.setCharge(missionRequest.getCharge());
        mission.setDescription(missionRequest.getDescription());
        mission.setCreatedDate(missionTmp.getCreatedDate());
        mission.setLastModifiedDate(missionTmp.getLastModifiedDate());
        this.missionRepository.save(mission);

        return mission;
    }

    @Override
    public List<MissionResponse> getMissions(){
        List<Mission> missions = this.missionRepository.findAll();
        List<MissionResponse> missionResponses = new ArrayList<>();

        for(Mission mission : missions){
            MissionResponse missionResponse = new MissionResponse();
            missionResponse.setId(mission.getId());
            missionResponse.setTitle(mission.getTitle());
            missionResponse.setLocation(mission.getLocation());
            missionResponse.setDifficulty(mission.getDifficulty());
            missionResponse.setBusinessHour(mission.getBusinessHour());
            missionResponse.setPhoneNumber(mission.getPhoneNumber());
            missionResponse.setCharge(mission.getCharge());
            missionResponse.setImageUrl(mission.getImageUrl());
            missionResponse.setDescription(mission.getDescription());

            missionResponses.add(missionResponse);
        }
        return missionResponses;
    }

    @Override
    public List<MissionResponse> readCategoryMissions(Long categoryId){
        List<CategoryMission> categoryMissions =  this.categoryMissionRepository.findByCategoryId(categoryId);
        List<MissionResponse> missionResponses = new ArrayList<>();


        for (CategoryMission categoryMission : categoryMissions) {
            Mission mission = this.missionRepository.findOne(categoryMission.getMissionId());
            MissionResponse missionResponse = new MissionResponse();
            missionResponse.setId(mission.getId());
            missionResponse.setTitle(mission.getTitle());
            missionResponse.setDescription(mission.getDescription());
            missionResponse.setLocation(mission.getLocation());
            missionResponse.setDifficulty(mission.getDifficulty());
            missionResponse.setBusinessHour(mission.getBusinessHour());
            missionResponse.setPhoneNumber(mission.getPhoneNumber());
            missionResponse.setCharge(mission.getCharge());
            missionResponse.setImageUrl(mission.getImageUrl());

            missionResponses.add(missionResponse);
        }

        return missionResponses;
    }


}
