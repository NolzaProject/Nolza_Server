package me.nolza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 7..
 */
@Setter
@Getter
@Entity
@ToString
@Table(name = "CATEGORY")
public class Category extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

}
