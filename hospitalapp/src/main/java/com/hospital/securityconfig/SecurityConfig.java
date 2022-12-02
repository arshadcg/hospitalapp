package com.hospital.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired	UserDetailsService userDetailsService;
	
	@Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	

	
@Bean
public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    auth.setUserDetailsService(userDetailsService);
    auth.setPasswordEncoder(getPasswordEncoder());
    return auth;
}

@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
	}


@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		http.authorizeRequests()
//		.antMatchers("/","/signup","/register").permitAll()
//		.and().formLogin().permitAll()
//		.and()
//		
//		.authorizeRequests()
//		.antMatchers("/super/**").hasAnyAuthority("SUPER")
//		.antMatchers("/admin/**").hasAnyAuthority("ADMIN","SUPER")
//		.antMatchers("/user/**").hasAnyAuthority("SUPER","ADMIN","USER")
//		.anyRequest()
//		.authenticated()
//		.and()
//		.logout()
//		.logoutSuccessUrl("/logout");
		
		http.authorizeRequests()
		.antMatchers("/super/**").hasAuthority("SUPER")
		.antMatchers("/user/**").hasAnyAuthority("USER","SUPER")
		.antMatchers("/doctor/**").hasAnyAuthority("DOCTOR","SUPER")
		.antMatchers("/","/home","/signup","/register","/logout","/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.csrf().disable()
		.formLogin()
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/");
		
			
	}


}
