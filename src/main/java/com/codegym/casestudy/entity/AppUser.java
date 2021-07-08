package com.codegym.casestudy.entity;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String firstName;

    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne
    private AppRole appRole;


}



