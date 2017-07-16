package de.serverfrog.awportal.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Serverfrog on 16.07.17.
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private long userId;

    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults to ORDINAL.
    @CollectionTable(name = "user_role")
    @Column(name = "role") // Column name in person_interest
    private Collection<Role> roles;

    @OneToOne
    private UniquePlayer uniquePlayer;

    private String username;
    private byte[] password;
    private boolean enabled;

}
