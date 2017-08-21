package me.nolza.controller.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by gain on 2017. 8. 7..
 */
@Data
@NoArgsConstructor
public class MissionRequest {

    private Long Id;

    @NotNull
    private String title;

    @NotNull
    private String location;

    @NotNull
    private String description;

    @NotNull
    private String level;
}

