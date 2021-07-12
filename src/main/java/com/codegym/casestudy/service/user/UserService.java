package com.codegym.casestudy.service.user;

import com.codegym.casestudy.entity.User;

import java.util.Optional;

public class UserService implements IUserService{
    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void remove(Long id) {

    }
}
