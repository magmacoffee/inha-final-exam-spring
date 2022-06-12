package kr.ac.inha.wgcloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/signup")
                .permitAll()
            .anyRequest()
            .authenticated();
        http
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login")
                .permitAll()
            .defaultSuccessUrl("/cloud/main")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String query1 = "SELECT id as username, CONCAT('{noop}', password) as password, true as enabled FROM emp WHERE id = ?";
        String query2 = "SELECT id as username, 'ROLE_USER' as authority FROM emp WHERE id = ?";
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(query1)
            .authoritiesByUsernameQuery(query2);
    }

}
