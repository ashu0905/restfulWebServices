package com.springbootms.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(ahr -> ahr.anyRequest().authenticated());
		httpSecurity.httpBasic(withDefaults());
		httpSecurity.csrf(csrf -> csrf.disable());
		return httpSecurity.build();
	}
}