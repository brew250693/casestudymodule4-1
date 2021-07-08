package com.codegym.casestudy.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
public class AppUserForm {
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

    @ManyToOne
    private AppRole appRole;

    @Transient
    private MultipartFile avatar;
}