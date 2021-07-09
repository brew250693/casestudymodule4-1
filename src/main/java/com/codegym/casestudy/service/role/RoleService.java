package com.codegym.casestudy.service.role;

import com.codegym.casestudy.entity.Role;
import com.codegym.casestudy.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository repository;

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void remove(Long id) {

    }
}
