package com.codegym.casestudy.security;

import com.codegym.casestudy.entity.AppUser;
import com.codegym.casestudy.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AppUser byUsername = userRepository.findByUsername(s);
        if (byUsername == null) {
            throw new UsernameNotFoundException("User with does not exists");
        }
        return new SpringUser(byUsername);
    }
}
