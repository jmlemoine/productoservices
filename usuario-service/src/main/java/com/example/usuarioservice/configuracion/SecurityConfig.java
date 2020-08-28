package com.example.usuarioservice.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration("MySecurityConfig")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // @Autowired
    // private

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Clase para encriptar contraseña
        // BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        //
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //permitiendo el acceso vía cors, crfs y los iframe.
        http.cors().disable();
        http.csrf().disable();
        /*http.headers().frameOptions().disable();
        //permitiendo el acceso.
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").authenticated()
                //.anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .authorizeRequests().antMatchers("/api/**").permitAll()*/
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.jsp",
                        "/**/*.do")
                .permitAll();
//                .anyRequest()
//                    .authenticated();

        http.headers().frameOptions().disable();
        http.addFilterBefore(new JWTAutorizacionFilter(), BasicAuthenticationFilter.class);

        // .and().addFilterBefore(new JWTAutorizacionFilter(), BasicAuthenticationFilter.class);
    }

}
