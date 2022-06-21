package kr.ac.inha.wgcloud.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfigV2 {

    private DataSource dataSource;

    public SecurityConfigV2(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
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
        return http.build();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        String query1 = "SELECT id as username, CONCAT('{noop}', password) as password, true as enabled FROM emp WHERE id = ?";
        String query2 = "SELECT id as username, 'ROLE_USER' as authority FROM emp WHERE id = ?";
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery(query1);
        users.setAuthoritiesByUsernameQuery(query2);
        return users;
    }

}
