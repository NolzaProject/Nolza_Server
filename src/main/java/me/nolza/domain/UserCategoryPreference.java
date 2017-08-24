package me.nolza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 21..
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "USER_CATEGORY_PREFERENCE")
@IdClass(UserCategoryPreferenceId.class)
public class UserCategoryPreference extends BaseEntity implements Serializable {

    @Id
    @Column(name = "CATEGORY_ID")
    private String categoryId;

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "POINT")
    private Integer point;

    @Column(name = "LAST_COMPLETED_TIME")
    private String lastCompletedTime;

}
