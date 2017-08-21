package me.nolza.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 21..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCategoryPreferenceId implements Serializable {
    private Long categoryId;
    private Long userId;

    public boolean equals(Object o) {
        return ((o instanceof UserCategoryPreferenceId)
                && categoryId == ((UserCategoryPreferenceId) o).getCategoryId() && userId == ((UserCategoryPreferenceId) o).getUserId());
    }

    public int hashCode() {
        return categoryId.intValue() + userId.intValue();
    }
}
