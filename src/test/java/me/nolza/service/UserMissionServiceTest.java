package me.nolza.service;

import groovy.util.logging.Slf4j;
import me.nolza.controller.model.request.UserMissionRequest;
import me.nolza.service.custom.UserMissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gain on 2017. 9. 3..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMissionServiceTest {

    @Autowired
    private UserMissionService userMissionService;

    @Test
    public void createUserMissionTest() throws IOException {
        File file = new File("/Users/gain/test.jpg");
        InputStream inputStream = new FileInputStream(file);
        MockMultipartFile mockMultipartFile = new MockMultipartFile("test", "test.jpg", "image/jpeg", inputStream);

        UserMissionRequest userMissionRequest = new UserMissionRequest();
        userMissionRequest.setUserId(1);
        userMissionRequest.setMissionId(1);
        userMissionRequest.setImage(mockMultipartFile);
        userMissionRequest.setLocation("location");
        userMissionRequest.setIschecked(false);
        userMissionRequest.setIscompleted(false);

        userMissionService.createUserMission(userMissionRequest);
    }
}
