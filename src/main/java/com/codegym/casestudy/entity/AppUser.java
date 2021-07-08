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

    @Pattern(regexp = "(^$|[0-9]{10,12})")
    private String phoneNumber;

    private String gender;

    private Date dateOfBirth;

    private String avatar;

    @ManyToOne
    private AppRole appRole;

    public AppUser(String firstName, String lastName, @Email String email, @Pattern(regexp = "(^$|[0-9]{10,12})") String phoneNumber, String gender, Date dateOfBirth, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }
}



