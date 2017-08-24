package me.nolza.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.nolza.controller.exception.UserMissionNotAcceptableException;
import me.nolza.controller.exception.UserMissionNotFoundException;
import me.nolza.controller.model.request.UserMissionRequest;
import me.nolza.controller.model.response.UserMissionResponse;
import me.nolza.domain.UserMission;
import me.nolza.repository.UserMissionRepository;
import me.nolza.service.custom.UserMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gain on 2017. 8. 12..
 */
@Service
@Slf4j
public class UserMissionServiceImpl implements UserMissionService {

    @Autowired
    private UserMissionRepository userMissionRepository;

    //TODO 미션 완료한 시간 넣어야 함
    @Override
    public void createUserMission(UserMissionRequest userMissionRequest) {
        UserMission userMission = UserMission.of(userMissionRequest.getUserId(), userMissionRequest.getMissionId(),
                userMissionRequest.getImageUri(), userMissionRequest.getLocation());
        this.userMissionRepository.save(userMission);
    }

    @Override
    public List<UserMissionResponse> readUserMissions(Long userId) {
        List<UserMission> userMissions = this.userMissionRepository.findByUserId(userId);
        List<UserMissionResponse> userMissionResponses = new ArrayList<>();

        if(userMissions.size() == 0){
            throw new UserMissionNotFoundException("수행된 미션이 없습니다.");
        }else{
            for (UserMission userMission : userMissions){
                userMissionResponses.add(UserMissionResponse.of(userMission));
            }
            return userMissionResponses;
        }
    }

    @Override
    public void updateUserMission(UserMissionRequest userMissionRequest){
        UserMission userMissionTmp = this.userMissionRepository.findOne(userMissionRequest.getId());

        if(userMissionTmp.getIscompleted()) {
            throw new UserMissionNotAcceptableException("이미 완료된 미션입니다.");
        }else {
            UserMission userMission = new UserMission();
            userMission.setId(userMissionTmp.getId());
            userMission.setUserId(userMissionTmp.getUserId());
            userMission.setMissionId(userMissionTmp.getMissionId());
            userMission.setImageUri(userMissionRequest.getImageUri());
            userMission.setLocation(userMissionRequest.getLocation());
            userMission.setIschecked(false);
            userMission.setIscompleted(false);
            userMission.setCreatedDate(userMissionTmp.getCreatedDate());
            userMission.setLastModifiedDate(userMissionTmp.getLastModifiedDate());

            this.userMissionRepository.save(userMission);
        }
    }

    @Override
    public void checkedUserMissions(List<UserMissionRequest> userMissionRequests) {
        for(UserMissionRequest userMissionRequest : userMissionRequests){
            UserMission userMissionTmp = this.userMissionRepository.findOne(userMissionRequest.getId());
            UserMission userMission = new UserMission();
            userMission.setId(userMissionTmp.getId());
            userMission.setUserId(userMissionTmp.getUserId());
            userMission.setMissionId(userMissionTmp.getMissionId());
            userMission.setImageUri(userMissionTmp.getImageUri());
            userMission.setLocation(userMissionTmp.getLocation());
            userMission.setIschecked(true);
            userMission.setIscompleted(userMissionRequest.getIscompleted());
            userMission.setCreatedDate(userMissionTmp.getCreatedDate());
            userMission.setLastModifiedDate(userMissionTmp.getLastModifiedDate());

            this.userMissionRepository.save(userMission);
        }
    }


}
