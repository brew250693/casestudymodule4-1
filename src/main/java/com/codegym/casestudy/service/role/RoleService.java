package com.codegym.casestudy.service.role;

import com.codegym.casestudy.entity.AppRole;
import com.codegym.casestudy.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository repository;

    @Override
    public AppRole findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Iterable<AppRole> findAll() {
        return null;
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(AppRole appRole) {

    }

    @Override
    public void remove(Long id) {

    }
}
