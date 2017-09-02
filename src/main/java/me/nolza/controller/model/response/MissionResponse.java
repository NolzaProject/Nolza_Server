package me.nolza.controller.model.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by gain on 2017. 8. 9..
 */
@Getter
@Setter
public class MissionResponse {
    private Long Id;
    private String title;
    private String location;
    private String difficulty;
    private String businessHour;
    private String phoneNumber;
    private String charge;
    private String description;
    private String imageUrl;
}
