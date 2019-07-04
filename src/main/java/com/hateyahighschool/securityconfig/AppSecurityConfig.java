package com.hateyahighschool.securityconfig;

/*
import com.hateyahighschool.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{

//    @Autowired
//    public MyUserDetailsService userDetailsService;


//    public AuthenticationProvider authProvider()
//    {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        //provider.setUserDetailsService(userDetailsService);
//        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        return provider;
//    }




    /*
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        List<UserDetails> userList = new ArrayList<>();
        userList.add(User.withDefaultPasswordEncoder().username("mamun").password("123456").roles("ADMIN").build());
        return new InMemoryUserDetailsManager(userList);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.antMatcher("/open").formLogin();
    }
}
*/