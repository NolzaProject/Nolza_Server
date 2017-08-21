package me.nolza.controller.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by gain on 2017. 8. 21..
 */
@Data
@NoArgsConstructor
public class UserKeywordRequest {
    @NotNull
    Long userId;

    @NotNull
    List<Long> keywordIds;
}
