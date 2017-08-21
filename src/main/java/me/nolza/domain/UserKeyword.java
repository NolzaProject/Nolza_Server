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
@Table(name = "USER_KEYWORD")
@IdClass(UserKeywordId.class)
public class UserKeyword extends BaseEntity implements Serializable {

    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Id
    @Column(name = "KEYWORD_ID")
    private Long keywordId;
}
