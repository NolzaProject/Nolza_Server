package me.nolza.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gain on 2017. 8. 12..
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "USER")
public class User extends BaseEntity implements Serializable {


    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NATION")
    private String nation;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "DURATION")
    private String duration;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public void addRoles(Role role){
        if(roles==null){
            roles = new ArrayList<>();
        }
        this.roles.add(role);
    }
}
