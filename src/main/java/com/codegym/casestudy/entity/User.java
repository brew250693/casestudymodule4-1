package com.codegym.casestudy.entity;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;


    private String password;



}



