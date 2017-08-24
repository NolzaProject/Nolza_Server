package me.nolza.controller.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by gain on 2017. 8. 12..
 */
@Data
@NoArgsConstructor
public class UserMissionRequest {

    private Long Id;

    @NotNull
    private Long userId;

    @NotNull
    private Long missionId;

    @NotNull
    private String imageUri;

    private String location;

    private Boolean Iscompleted;

    private Boolean Ischecked;

}
