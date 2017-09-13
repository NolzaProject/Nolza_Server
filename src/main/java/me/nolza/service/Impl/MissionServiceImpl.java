package me.nolza.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.nolza.controller.exception.MissionNotFoundException;
import me.nolza.controller.model.request.MissionRequest;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.controller.model.response.RecommendMissionsResponse;
import me.nolza.controller.model.response.MissionResponse;
import me.nolza.domain.*;
import me.nolza.repository.*;
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

    @Autowired
    private UserMissionRepository userMissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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
    public RecommendMissionsResponse recommendMissions(String email){
        List<CategoryMission> categoryMissions =  this.categoryMissionRepository.findAll();
        List<Category> categories = this.categoryRepository.findAll();

        List<String> categoryTitles = new ArrayList<>();

        for(Category category : categories){
            categoryTitles.add(category.getTitle());
        }

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

        RecommendMissionsResponse recommendMissionsResponse = new RecommendMissionsResponse();
        recommendMissionsResponse.setCategoryTitles(categoryTitles);
        recommendMissionsResponse.setMissionResponses(missionResponses);

        return recommendMissionsResponse;
    }

    @Override
    public NolzaApiResponse<List<MissionResponse>> searchMissions(String description) {
        List<Mission> missions = this.missionRepository.findByDescriptionContaining(description);
        List<MissionResponse> missionResponses = new ArrayList<>();

        if(missions.size() == 0){
            return new NolzaApiResponse<List<MissionResponse>>(NolzaApiResponse.NOT_FOUND);
        }else {
            for(Mission mission : missions){
                MissionResponse missionResponse = new MissionResponse();
                missionResponse.setId(mission.getId());
                missionResponse.setDescription(mission.getDescription());
                missionResponse.setImageUrl(mission.getImageUrl());
                missionResponse.setLocation(mission.getLocation());
                missionResponse.setBusinessHour(mission.getBusinessHour());
                missionResponse.setCharge(mission.getCharge());
                missionResponse.setDifficulty(mission.getDifficulty());
                missionResponse.setPhoneNumber(mission.getPhoneNumber());
                missionResponse.setTitle(mission.getTitle());

                missionResponses.add(missionResponse);
            }
            return new NolzaApiResponse<>(missionResponses);
        }
    }
}
