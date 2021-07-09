package com.codegym.casestudy.security;

import com.codegym.casestudy.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class SpringUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public SpringUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList("user"));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
