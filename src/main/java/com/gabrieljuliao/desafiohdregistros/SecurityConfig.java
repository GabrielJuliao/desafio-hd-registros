package com.gabrieljuliao.desafiohdregistros;

import com.gabrieljuliao.desafiohdregistros.services.UserDetailsServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Getter
@Setter
@ConfigurationProperties(prefix = "desafiohdregistros.sec-config")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;
    private final UserDetailsServiceImpl userDetailsService;

    /**
     * Injetado pelo props config!
     */
    private String usersQuery;
    private String authoritiesQuery;

    public SecurityConfig(DataSource dataSource, UserDetailsServiceImpl userDetailsService) {
        this.dataSource = dataSource;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(authoritiesQuery);
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }


    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.httpBasic()
                .and().authorizeRequests()
                .antMatchers("/signup").permitAll()
                .antMatchers("/", "/conta", "/conta/*").authenticated()
                .and().csrf().disable().formLogin().disable();

        ///allow h2 console
        security.headers().frameOptions().sameOrigin();
    }

}
