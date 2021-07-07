package com.codegym.casestudy.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String fisrtName, lastName, phone, address, username, password;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Role role;
}
