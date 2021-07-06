//package com.codegym.casestudy.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "role")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private String name;
//
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//    private List<User> user;
//}
