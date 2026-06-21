package com.spring.bioMedical.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security Configuration - Matching ORIGINAL project
 * Uses NoOpPasswordEncoder for plaintext passwords (as in original DB)
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder passwordEncoder() {
		// Original project uses plaintext passwords
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authz -> authz
				.antMatchers("/", "/test", "/register", "/css/**", "/js/**", "/images/**", 
							"/fonts/**", "/vendor/**", "/resources/**", "/login/**", "/reg/**",
							"/doctor/**", "/scss/**", "/webjars/**", "/favicon.ico", "/error").permitAll()
				.antMatchers("/user/**").hasAuthority("ROLE_USER")
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				.antMatchers("/doctor/**").hasAuthority("ROLE_DOCTOR")
				.anyRequest().authenticated()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.defaultSuccessUrl("/user/index", true)
				.permitAll()
			)
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll()
			)
			.exceptionHandling(ex -> ex
				.accessDeniedPage("/login")
			)
			.csrf().disable();
		
		return http.build();
	}
}
