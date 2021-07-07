//package com.codegym.casestudy.entity;
//
//import com.sun.istack.NotNull;
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Users {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull
//    private String fisrtName, lastName, phone, address, username, password;
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Role role;
//
//    }
//
//
//
