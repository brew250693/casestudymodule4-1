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

        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/index", "/login").permitAll();

        http.authorizeRequests().antMatchers("/static/**", "/templates/**").permitAll();

        http.authorizeRequests().antMatchers("/api/auth/**", "/admin/create-product", "/admin/edit-product", "/admin/delete-product", "/admin/list-product").permitAll()
        .and()
        .authorizeRequests().antMatchers("/api/auth/**", "/admin/create-category", "/admin/edit-category", "/admin/delete-category", "/admin/list-category").permitAll();
        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
        // Nếu chưa login, nó sẽ redirect tới trang /login.

        http.authorizeRequests().antMatchers("/shop/profile/**","/shop/favorite/**" ,"/shop/checkout")
                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // Trang chỉ dành cho ADMIN
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

        // Khi người dùng đã login, với vai trò XX.
        // Nhưng truy cập vào trang yêu cầu vai trò YY,
        // Ngoại lệ AccessDeniedException sẽ ném ra.

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403page");
        // Cấu hình cho Login Form.
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

