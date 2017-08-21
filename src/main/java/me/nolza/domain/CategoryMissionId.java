package me.nolza.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 9..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryMissionId implements Serializable {
    private Long categoryId;
    private Long missionId;

    public boolean equals(Object o) {
        return ((o instanceof CategoryMissionId)
                && categoryId == ((CategoryMissionId) o).getCategoryId() && missionId == ((CategoryMissionId) o).getMissionId());
    }

    public int hashCode() {
        return categoryId.intValue() + missionId.intValue();
    }
}
