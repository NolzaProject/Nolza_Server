package me.nolza.controller.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Created by gain on 2017. 8. 9..
 */
@Getter
@Setter
public class CategoryMissionResponse {
    private Long categoryId;
    private List<Long> missionIds;
}
