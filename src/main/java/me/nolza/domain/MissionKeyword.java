package me.nolza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 19..
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "MISSION_KEYWORD")
@IdClass(MissionKeywordId.class)
public class MissionKeyword extends BaseEntity implements Serializable{
    @Id
    @Column(name = "MISSION_ID")
    private Long missionId;

    @Id
    @Column(name = "KEYWORD_ID")
    private Long keywordId;
}
