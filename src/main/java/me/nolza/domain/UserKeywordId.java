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
public class UserKeywordId implements Serializable{
    private Long userId;
    private Long keywordId;

    public boolean equals(Object o) {
        return ((o instanceof UserKeywordId)
                && userId == ((UserKeywordId) o).getUserId() && keywordId == ((UserKeywordId) o).getKeywordId());
    }

    public int hashCode() {
        return userId.intValue() + keywordId.intValue();
    }

}
