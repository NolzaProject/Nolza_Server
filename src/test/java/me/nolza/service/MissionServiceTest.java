package me.nolza.service;

import groovy.util.logging.Slf4j;
import me.nolza.controller.model.request.MissionRequest;
import me.nolza.controller.model.response.MissionResponse;
import me.nolza.domain.Mission;
import me.nolza.service.custom.MissionService;
import me.nolza.service.custom.S3Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.*;
import java.util.List;

/**
 * Created by gain on 2017. 9. 2..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MissionServiceTest {
    @Autowired
    private MissionService missionService;

    @Autowired
    private S3Service s3Service;

    private MockMvc mockMvc;

    @Test
    public void createMissionTest() throws IOException {
//        File file = new File("/Users/gain/img1.jpg");
//        InputStream inputStream = new FileInputStream(file);
//        MockMultipartFile mockMultipartFile = new MockMultipartFile("img1", "img1.jpg", "image/jpeg", inputStream);
//
//        MissionRequest missionRequest = new MissionRequest();
//        missionRequest.setTitle("title");
//        missionRequest.setLocation("location");
//        missionRequest.setCharge("charge");
//        missionRequest.setBusinessHour("hour");
//        missionRequest.setDifficulty("상");
//        missionRequest.setDescription("description");
//        missionRequest.setPhoneNumber("02-0000-00000");
//        missionRequest.setImage(mockMultipartFile);
//
//        s3Service.createObject(missionRequest.getImage());
//        String imageUrl = s3Service.findObject(missionRequest.getImage().getOriginalFilename());
//        missionService.createMission(missionRequest, imageUrl);
    }

    @Test
    public void getMissionsTest(){
        List<MissionResponse>  result = this.missionService.getMissions();
        assertThat(result).isNotNull();
    }
}
