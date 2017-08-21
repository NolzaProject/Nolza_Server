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

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "DIFFICULTY")
    private String difficulty;

    @Column(name = "BUSINESS_HOUR")
    private String businessHour;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CHARGE")
    private String charge;

    @Column(name = "DESCRIPTION")
    private String description;
}
