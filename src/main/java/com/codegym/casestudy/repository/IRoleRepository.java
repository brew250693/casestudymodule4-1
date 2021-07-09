package com.codegym.casestudy.repository;

import com.codegym.casestudy.common.ERole;
import com.codegym.casestudy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
