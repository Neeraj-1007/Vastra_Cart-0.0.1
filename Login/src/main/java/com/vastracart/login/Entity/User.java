package com.vastracart.login.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(generator = "neeraj",strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;


    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "rolestab",joinColumns = @JoinColumn(name="id"))

    @Column(name = "role")
    private Set<String> role;
}
