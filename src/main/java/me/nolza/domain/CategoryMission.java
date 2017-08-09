package me.nolza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by gain on 2017. 8. 7..
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "CATEGORY_MISSION")
@IdClass(CategoryMissionId.class)
public class CategoryMission {

    @Id
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Id
    @Column(name = "MISSION_ID")
    private Long missionId;

}
