//package com.codegym.casestudy.config;
//
//
//import com.codegym.casestudy.service.user.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private IUserService userService;
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService((UserDetailsService) userService).passwordEncoder(
//                NoOpPasswordEncoder.getInstance()
//        );
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/create-product").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/user/**").hasRole("USER")
//                .and()
//                .authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//        http.csrf().disable();
//    }
//}
