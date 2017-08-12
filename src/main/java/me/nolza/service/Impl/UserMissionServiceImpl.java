package me.nolza.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.nolza.controller.exception.UserMissionNotFoundException;
import me.nolza.controller.model.request.UserMissionRequset;
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

    @Override
    public void createUserMission(UserMissionRequset userMissionRequset) {
        UserMission userMission = new UserMission();
        userMission.setUserId(userMissionRequset.getUserId());
        userMission.setMissionId(userMissionRequset.getMissionId());
        userMission.setImageUri(userMissionRequset.getImageUri());
        userMission.setLocation(userMissionRequset.getLocation());
        userMission.setIscompleted(false);
        userMission.setIschecked(false);

        this.userMissionRepository.save(userMission);
    }

    @Override
    public List<UserMissionResponse> getUserMissionList(Long userId) {
        List<UserMission> userMissionList = this.userMissionRepository.findByUserId(userId);
        List<UserMissionResponse> userMissionResponseList = new ArrayList<>();

        if(userMissionList == null){
            throw new UserMissionNotFoundException("미션을 먼저 수행해주세요!");
        }else{
            for (UserMission userMission : userMissionList){
                userMissionResponseList.add(UserMissionResponse.of(userMission));
            }

            return userMissionResponseList;
        }
    }
}
