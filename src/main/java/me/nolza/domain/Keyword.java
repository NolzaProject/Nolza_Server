package me.nolza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 19..
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "KEYWORD")
public class Keyword extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "KEYWORD")
    private String keyword;
}
