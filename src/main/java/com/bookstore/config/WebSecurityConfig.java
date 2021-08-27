package com.bookstore.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bookstore.config.jwt.JwtAuthenticationFilter;
import com.bookstore.config.jwt.UnauthorizedEntryPoint;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "userService")
    private UserDetailsService userDetailsService;

    @Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/login", "/api/auth/register",
                		"/api/books/getAll","/api/users/getAll",
                		"/api/books/getById",
                		"/api/books/add",
                		"/api/books/getByCategoryId",
                		"/api/books/countGetAll",
                		"/api/users/getById",
                		"/api/users/getByCategoryId",
                		"/api/users/getByPublisherId",
                		"/api/users/getByAuthorId",
                		"/api/users/countGetAll",
                		"/api/users/getByUsername",
                		"/api/categories/getAll",
                		"/api/categories/getById",
                		"/api/categories/add",
                		"/api/categories/delete",
                		"/api/categories/update",
                		"/api/categories/countGetAll",
                		"/api/customers/getAll",
                		"/api/customers/countGetAll",
                		"/api/customers/add",
                		"/api/customers/update",
                		"/api/customers/delete",
                		"/api/publishers/getAll",
                		"/api/publishers/getById",
                		"/api/publishers/add",
                		"/api/publishers/update",
                		"/api/publishers/delete",
                		"/api/authors/getAll",
                		"/api/authors/getById",
                		"/api/authors/add",
                		"/api/authors/update",
                		"/api/authors/delete",
                		"/api/images/add",
                		"/api/images/getAll",
                		"/swagger-ui.html",
                		"/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }

}