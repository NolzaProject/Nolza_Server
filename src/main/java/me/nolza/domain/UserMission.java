package me.nolza.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 12..
 */
@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_MISSION")
public class UserMission extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "USES_ID")
    private Long userId;

    @Column(name = "MISSION_ID")
    private Long missionId;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "ISCOMPLETED", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean Iscompleted;

    @Column(name = "ISCHECKED", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean Ischecked;

    public static UserMission of(long userId, long missionId, String imageUrl){
        return UserMission.builder()
                .userId(userId)
                .missionId(missionId)
                .imageUrl(imageUrl)
                .Iscompleted(false)
                .Ischecked(false)
                .build();
    }

}
