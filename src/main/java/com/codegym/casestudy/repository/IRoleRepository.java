package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
