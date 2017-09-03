package me.nolza.controller.model.response;

import lombok.*;
import me.nolza.domain.UserMission;
import org.joda.time.DateTime;


/**
 * Created by gain on 2017. 8. 12..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserMissionResponse {

    private Long Id;

    private Long userId;

    private Long missionId;

    private String imageUrl;

    private String location;

    private Boolean Iscompleted;

    private Boolean Ischecked;

    private DateTime createdDate;


    public static UserMissionResponse of(UserMission userMission){
        return UserMissionResponse.builder()
                .Id(userMission.getId())
                .userId(userMission.getUserId())
                .missionId(userMission.getMissionId())
                .imageUrl(userMission.getImageUrl())
                .location(userMission.getLocation())
                .Iscompleted(userMission.getIscompleted())
                .Ischecked(userMission.getIschecked())
                .createdDate(userMission.getCreatedDate())
                .build();
    }
}
