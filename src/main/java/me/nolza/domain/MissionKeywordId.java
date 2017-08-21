package me.nolza.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 19..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissionKeywordId implements Serializable {
    private Long missionId;
    private Long keywordId;

    public boolean equals(Object o) {
        return ((o instanceof MissionKeywordId)
                && missionId == ((MissionKeywordId) o).getMissionId() && keywordId == ((MissionKeywordId) o).getKeywordId());
    }

    public int hashCode() {
        return missionId.intValue() + keywordId.intValue();
    }

}
