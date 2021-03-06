package com.codegym.casestudy.config;


import com.codegym.casestudy.service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFiler() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.csrf().disable();

        // C??c trang kh??ng y??u c???u login
        http.authorizeRequests().antMatchers("/index", "/login").permitAll();

        http.authorizeRequests().antMatchers("/static/**", "/templates/**").permitAll();

//        http.authorizeRequests().antMatchers("/admin/**", "/user/**").permitAll();

        http.authorizeRequests().antMatchers("/api/auth/**").permitAll();
        // Trang /userInfo y??u c???u ph???i login v???i vai tr?? ROLE_USER ho???c ROLE_ADMIN.
        // N???u ch??a login, n?? s??? redirect t???i trang /login.

        http.authorizeRequests().antMatchers("/shop/profile/**","/shop/favorite/**" ,"/shop/checkout")
                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // Trang ch??? d??nh cho ADMIN
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

        // Khi ng?????i d??ng ???? login, v???i vai tr?? XX.
        // Nh??ng truy c???p v??o trang y??u c???u vai tr?? YY,
        // Ngo???i l??? AccessDeniedException s??? n??m ra.

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403page");
        // C???u h??nh cho Login Form.
        http.authorizeRequests().and().formLogin()
                // .loginProcessingUrl("/login")
                .loginPage("/login")
                // .failureUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                // .failureUrl("/login")
                .failureForwardUrl("/login").defaultSuccessUrl("/successLogin", true)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index");
    }
}

