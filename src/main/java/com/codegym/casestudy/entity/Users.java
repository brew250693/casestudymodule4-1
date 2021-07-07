package com.codegym.casestudy.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fisrtName, lastName, phone, address, username, password;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_roles",
//            joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) },
//            inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
//    @OrderBy("name")
    private Role role;
}
