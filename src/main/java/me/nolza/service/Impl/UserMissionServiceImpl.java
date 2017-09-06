package me.nolza.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.nolza.controller.exception.UserMissionNotAcceptableException;
import me.nolza.controller.exception.UserMissionNotFoundException;
import me.nolza.controller.model.request.UserMissionRequest;
import me.nolza.controller.model.response.UserMissionResponse;
import me.nolza.domain.User;
import me.nolza.domain.UserMission;
import me.nolza.repository.UserMissionRepository;
import me.nolza.repository.UserRepository;
import me.nolza.service.custom.S3Service;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private S3Service s3Service;

    //TODO 미션 완료한 시간 넣어야 함
    @Override
    public void createUserMission(UserMissionRequest userMissionRequest) {
        s3Service.createObject(userMissionRequest.getImage(), "usermission");
        String imageUrl = s3Service.findObject("usermission", userMissionRequest.getImage().getOriginalFilename());
        User user = this.userRepository.findByEmail(userMissionRequest.getEmail());
        UserMission userMission = UserMission.of(user.getId(), userMissionRequest.getMissionId(),
                imageUrl, userMissionRequest.getLocation());
        this.userMissionRepository.save(userMission);
    }

    @Override
    public List<UserMissionResponse> readUserMissions(String email) {
        User user = this.userRepository.findByEmail(email);
        List<UserMission> userMissions = this.userMissionRepository.findByUserId(user.getId());
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

    //TODO 이미지 삭제
    @Override
    public void updateUserMission(UserMissionRequest userMissionRequest){
        s3Service.createObject(userMissionRequest.getImage(), "usermission");
        String imageUrl = s3Service.findObject("usermission", userMissionRequest.getImage().getOriginalFilename());
        UserMission userMissionTmp = this.userMissionRepository.findOne(userMissionRequest.getId());

        if(userMissionTmp.getIscompleted()) {
            throw new UserMissionNotAcceptableException("이미 완료된 미션입니다.");
        }else {
            UserMission userMission = new UserMission();
            userMission.setId(userMissionTmp.getId());
            userMission.setUserId(userMissionTmp.getUserId());
            userMission.setMissionId(userMissionTmp.getMissionId());
            userMission.setImageUrl(imageUrl);
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
            userMission.setImageUrl(userMissionTmp.getImageUrl());
            userMission.setLocation(userMissionTmp.getLocation());
            userMission.setIschecked(true);
            userMission.setIscompleted(userMissionRequest.getIscompleted());
            userMission.setCreatedDate(userMissionTmp.getCreatedDate());
            userMission.setLastModifiedDate(userMissionTmp.getLastModifiedDate());

            this.userMissionRepository.save(userMission);
        }
    }


}
