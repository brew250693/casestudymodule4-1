package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
