//package com.codegym.casestudy.service.user;
//
//import com.codegym.casestudy.entity.Users;
//import com.codegym.casestudy.repository.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserService  implements IUserService, UserDetailsService {
//
//    @Autowired
//    private IUserRepository repo;
//
//
//    @Override
//    public Users getUserByName(String name) {
//        return repo.findByUsername(name);
//    }
//
//
//    //chuyen doi tuong thuoc lop User sang dt thuoc lop UserDetails
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //lay doi tuong thuoc lop AppUser
//        Users user = this.getUserByName(username);
//        //lay quyen cua doi tuong do
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(user.getRole());
//
//        //Chuyen doi tuong do sang UserDetail
//
//        UserDetails userDetails = new User(
//                user.getUsername(),
//                user.getPassword(),
//                authorities
//        );
//
//        return userDetails;
//    }
//}