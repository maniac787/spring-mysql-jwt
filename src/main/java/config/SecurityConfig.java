package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    AuthenticationManager auth;

    /*la siguiente configuración será para el caso de
     usuarios en una base de datos*/
    @Bean
    public JdbcUserDetailsManager usersDetailsJdbc(DataSource dataSource) {
        JdbcUserDetailsManager jdbcDetails = new JdbcUserDetailsManager(dataSource);

        jdbcDetails.setUsersByUsernameQuery("select username, password, enabled"
                + " from users where username=?");
        jdbcDetails.setAuthoritiesByUsernameQuery("select username, authority "
                + "from authorities where username=?");
        return jdbcDetails;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/contactos").hasAnyRole("ADMIN")
                .antMatchers("/contactos").authenticated()
                .and()
                .addFilter(new JWTAuthorizationFilter(auth));
        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration conf) throws Exception {
        auth = conf.getAuthenticationManager();
        return auth;
    }
}

