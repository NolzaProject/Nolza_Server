package me.nolza.Controller;

import com.google.gson.Gson;
import groovy.util.logging.Slf4j;
import me.nolza.controller.model.request.MissionRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gain on 2017. 9. 3..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class MissionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateMission() throws Exception {
//        File file = new File("/Users/gain/img1.jpg");
//        System.out.println(file);
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
//        Gson gson = new Gson();
//        String json = gson.toJson(missionRequest);
//
//        MvcResult mvcResult = mockMvc.perform(post("/api/v1/missions")
//                .content(json)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.code", is(200)))
//                .andReturn();
    }

    @Test
    public void testDeleteMission() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/api/v1/missions/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
