package com.codegym.casestudy.service.user;

import com.codegym.casestudy.entity.AppUser;
import com.codegym.casestudy.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<AppUser>, UserDetailsService {
    AppUser getUserByUsername(String username);
    AppUser getCurrentUser();
}
