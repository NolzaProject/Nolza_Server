package me.nolza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by gain on 2017. 8. 14..
 */

@Entity
@Getter
@Setter
@ToString
@Table(name = "ROLE")
public class Role implements Serializable{

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "ROLE")
    private String role;

}
