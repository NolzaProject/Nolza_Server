package me.nolza.controller.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Created by gain on 2017. 8. 12..
 */
@Data
@NoArgsConstructor
public class UserMissionRequest {

    private Long Id;

    @NotNull
    private String email;

    @NotNull
    private long missionId;

    private String location;

    private Boolean Iscompleted;

    private Boolean Ischecked;

    @NotNull
    private MultipartFile image;
}
