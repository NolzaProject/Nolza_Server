package me.nolza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 7..
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "MISSION")
public class Mission extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "KEYWORD")
    private String keyword;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DIFFICULTY")
    private String difficulty;
}
