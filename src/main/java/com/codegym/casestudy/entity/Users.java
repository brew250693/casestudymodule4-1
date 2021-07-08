package com.codegym.casestudy.entity;

import com.sun.istack.NotNull;
import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email, password, firstName, lastName;

    }



