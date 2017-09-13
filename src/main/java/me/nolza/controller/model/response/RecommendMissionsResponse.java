package me.nolza.controller.model.response;

import lombok.Getter;
import lombok.Setter;
import me.nolza.domain.Mission;

import java.util.List;

/**
 * Created by gain on 2017. 9. 10..
 */
@Getter
@Setter
public class RecommendMissionsResponse {
    private List<String> categoryTitles;
    private List<MissionResponse> missionResponses;
}
