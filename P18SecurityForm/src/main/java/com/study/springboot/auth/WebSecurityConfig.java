package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.DispatcherType;

@Configuration
//@EnableWebSecurity 스프링시큐리티 버전에 따라 없어도됨
public class WebSecurityConfig {
	@Autowired
	public AuthenticationFailureHandler authFailHandler;
	@Autowired
	public AuthenticationSuccessHandler authHandler;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests().antMatcher("/") spring security 버전이 다름
		http.csrf().disable().cors().disable();
		http.authorizeHttpRequests(request -> request
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/").permitAll()
				.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
				.requestMatchers("/guest/**").permitAll()
				.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()); //모든 요청 인증
		http.formLogin()
				.loginPage("/loginForm")  //만든 로그인 폼 경로 입력 default : /login
				.loginProcessingUrl("/j_spring_security_check")
//				.failureUrl("/loginError");
//				.failureUrl("/loginError?error")
				.failureHandler(authFailHandler)
				.defaultSuccessUrl("/")
				.successHandler(authHandler)
//				.successForwardUrl("/forward")
				.usernameParameter("j_username")
				.passwordParameter("j_password")
				.permitAll();
		http.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/loginForm")
				.permitAll();
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailService() {
		UserDetails user = User.withUsername("user")
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.build();
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
		UserDetails[] userDetails = new UserDetails[2];
		userDetails[0] = user;
		userDetails[1] = admin;
		System.out.print(">> ");
		System.out.print(passwordEncoder().encode("1234"));
		System.out.println(" << ");
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
//		StandardPasswordEncoder()-SHA256
//		NoOpPasswordEncoder()-암호화하지 않은 데이터
	}
}
