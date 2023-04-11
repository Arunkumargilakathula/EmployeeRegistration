package com.tcl.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class LibrarySecurityConfig {
private static final String[] SECURED_URLs = {"/employee/**"};

private static final String[] UN_SECURED_URLs = {
        "/employee/deleteEmployeeById/{id}",
        "/employee/update/{id}",
        "/users/**"
};

@Bean
public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}
@Bean
public UserDetailsService userDetailsService(){
    return new LibraryUserDetailsService();
}
@Bean
public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
}
//The authentication provider created is a DaoAuthenticationProvider, which is an implementation of AuthenticationProvider
//that retrieves user details from a UserDetailsService and performs authentication based on those details.
//The userDetailsService() method is called to provide an instance
//of the UserDetailsService to the DaoAuthenticationProvider.

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    return http.csrf().disable()
//            .authorizeHttpRequests()
//            .requestMatchers(UN_SECURED_URLs).permitAll().and()
//            .authorizeHttpRequests().requestMatchers(SECURED_URLs)
//            .hasAuthority("ADMIN").anyRequest()
//            .authenticated().and().httpBasic().and().build();
	
	 return http.csrf().disable()
             .authorizeRequests()
                 .antMatchers(UN_SECURED_URLs).permitAll()
                 .antMatchers(SECURED_URLs).hasAuthority("ADMIN")
                 .anyRequest().authenticated()
                 .and().formLogin().and().httpBasic()
                 .and().build();


}

}