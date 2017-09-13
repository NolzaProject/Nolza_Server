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

    private Boolean Iscompleted;

    private Boolean Ischecked;

    public static UserMissionResponse of(UserMission userMission){
        return UserMissionResponse.builder()
                .Id(userMission.getId())
                .userId(userMission.getUserId())
                .missionId(userMission.getMissionId())
                .imageUrl(userMission.getImageUrl())
                .Iscompleted(userMission.getIscompleted())
                .Ischecked(userMission.getIschecked())
                .build();
    }
}
