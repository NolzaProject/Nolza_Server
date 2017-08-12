package me.nolza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 12..
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "USER_MISSION")
public class UserMission extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "USES_ID")
    private Long userId;

    @Column(name = "MISSION_ID")
    private Long missionId;

    @Column(name = "IMAGE_URI")
    private String imageUri;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "ISCOMPLETED", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean Iscompleted;

    @Column(name = "ISCHECKED", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean Ischecked;
}
